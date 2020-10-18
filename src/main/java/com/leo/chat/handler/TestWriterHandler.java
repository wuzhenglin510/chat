package com.leo.chat.handler;

import com.leo.chat.manager.ChannelGround;
import com.leo.chat.proto.ChatPackOuterClass;
import com.leo.chat.proto.data.SubscribeOuterClass;
import com.leo.chat.util.ResultUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class TestWriterHandler extends SimpleChannelInboundHandler<Object> {

    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        ctx.pipeline().writeAndFlush(ResultUtil.buildPack("222221", true));
    }
}
