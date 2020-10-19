<template>
  <div>
    <el-container
      class="el-container"
      style="box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)"
    >
      <el-header class="el-header">
        聊天窗口
      </el-header>
      <el-main v-html="msg"> </el-main>
      <el-footer>
        <el-row :gutter="20">
          <el-col :span="19">
            <el-input
              type="textarea"
              :rows="2"
              placeholder="请输入内容"
              v-model="sending"
            >
            </el-input>
          </el-col>
          <el-col :span="2"
            ><el-button type="primary" v-on:click="onSend"
              >发送</el-button
            ></el-col
          >
        </el-row>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
var proto = require('../js/ChatPack_pb.js');

export default {
  name: "HelloWorld",
  props: {},
  data: function() {
    return {
      ws: null,
      sending: "",
      msg: ""
    };
  },
  methods: {
    onSend: function() {
      this.msg = this.msg + `</br>我发: ${this.sending}`;
      let chatPack = new proto.ChatPack();
      chatPack.setType(proto.ChatPack.Type.SUBSCRIBE);
      let message = new proto.data.Message();
      message.setUid("123456");
      message.setSendtime(new Date().getTime())
      message.addTopics("room1");
      message.setContent(this.sending);
      chatPack.setMessage(message);
      let bytes = chatPack.serializeBinary();
      this.ws.send(bytes);
      this.sending = "";
    },
  },
  mounted: function () {
    this.ws = new WebSocket("ws://localhost:9001/ws");
    let that = this;

    this.ws.onopen = function() {
      let chatPack = new proto.ChatPack();
      chatPack.setType(proto.ChatPack.Type.SUBSCRIBE);
      let subsribe = new proto.data.Subscribe();
      subsribe.setUid("123456");
      subsribe.addTopics("room1");
      subsribe.setTicket("roomTicket");
      chatPack.setSubscribe(subsribe);
      let bytes = chatPack.serializeBinary();
      that.ws.send(bytes);
    }

    this.ws.onmessage = function(evt) {
      let received_msg = evt.data;
      let reader = new FileReader();
      reader.readAsArrayBuffer(evt.data);
      reader.onload = function(e) {
        var buf = new Uint8Array(reader.result);
        let data = proto.ChatPack.deserializeBinary(buf);
        if (data.getDataCase() == proto.ChatPack.DataCase.MESSAGE) {
          that.msg = that.msg + `</br>收到: ${data.getMessage().getContent()}`;
        }
      }
    }

    this.ws.onclose = function() {
      alert("连接已关闭...");
    }
  }
};
</script>

<style>
body {
  width: 50%;
  margin: 0px auto;
}
.el-container {
  margin-bottom: 40px;
}
.el-main {
  height: 600px;
}
.el-header,
.el-footer {
  background-color: #b3c0d1;
  color: #333;
  text-align: center;
  line-height: 60px;
}
</style>
