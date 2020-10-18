package com.leo.chat.handler;

import com.leo.chat.proto.ChatPackOuterClass;
import com.leo.chat.proto.data.ResultOuterClass;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ProtoBufferFrameEncoder extends MessageToMessageEncoder<ChatPackOuterClass.ChatPack> {

    protected void encode(ChannelHandlerContext ctx, ChatPackOuterClass.ChatPack msg, List<Object> out) throws Exception {
        out.add(msg.toByteString());
    }
}
