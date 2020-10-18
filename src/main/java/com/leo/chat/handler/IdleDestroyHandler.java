package com.leo.chat.handler;

import com.leo.chat.proto.ChatPackOuterClass;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IdleDestroyHandler extends SimpleChannelInboundHandler<ChatPackOuterClass.ChatPack> {

    private int lossPingTimes = 0;
    private int maxLossPingTimes = 3;

    public IdleDestroyHandler(int maxIdleTimes) {
        this.maxLossPingTimes = maxIdleTimes;
    }

    public IdleDestroyHandler() {}

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ChatPackOuterClass.ChatPack chatPack) throws Exception {
        lossPingTimes = 0;
        if (chatPack.getType().equals(ChatPackOuterClass.ChatPack.Type.PING)) {
            ChatPackOuterClass.ChatPack pongMessage = ChatPackOuterClass.ChatPack.newBuilder()
                    .setType(ChatPackOuterClass.ChatPack.Type.PONG)
                    .build();
            channelHandlerContext.channel().writeAndFlush(pongMessage);
        } else {
            channelHandlerContext.fireChannelRead(chatPack);
        }
    }


    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            if (idleStateEvent.state() == IdleState.READER_IDLE) {
                lossPingTimes++;
                if (lossPingTimes > maxLossPingTimes) {
                    log.info("超时未ping");
                    ctx.channel().close();
                }
            }
        }
    }


}
