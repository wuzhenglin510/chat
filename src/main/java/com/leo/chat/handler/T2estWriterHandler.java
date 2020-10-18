package com.leo.chat.handler;

import com.leo.chat.util.ResultUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class T2estWriterHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        channelHandlerContext.channel().writeAndFlush( ResultUtil.buildPack("1", true));
    }

}
