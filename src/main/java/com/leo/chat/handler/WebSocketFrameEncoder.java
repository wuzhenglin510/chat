package com.leo.chat.handler;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.leo.chat.proto.ChatPackOuterClass;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.buffer.UnpooledHeapByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class WebSocketFrameEncoder extends MessageToMessageEncoder<ByteString> {

    protected void encode(ChannelHandlerContext ctx, ByteString msg, List<Object> out) throws Exception {
        out.add(new BinaryWebSocketFrame(Unpooled.wrappedBuffer(msg.toByteArray())));
    }

}
