package com.leo.chat.handler;

import com.leo.chat.manager.ChannelGround;
import com.leo.chat.proto.ChatPackOuterClass;
import com.leo.chat.proto.data.MessageOuterClass;
import com.leo.chat.proto.data.SubscribeOuterClass;
import com.leo.chat.util.ResultUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class MessageHandler extends SimpleChannelInboundHandler<ChatPackOuterClass.ChatPack> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ChatPackOuterClass.ChatPack chatPack) throws Exception {
        if (ChatPackOuterClass.ChatPack.DataCase.MESSAGE.equals(chatPack.getDataCase())) {
            ChatPackOuterClass.ChatPack result = null;
            Channel channel = channelHandlerContext.channel();
            MessageOuterClass.Message message = chatPack.getMessage();
            if (message.getTopicsList() != null && !message.getTopicsList().isEmpty()) {
                boolean allSubscribed = ChannelGround.checkHasSubscribe(message.getTopicsList(), channel);
                if (allSubscribed) {
                    ChannelGround.sendMessage(channel, message.getUid(), message.getSendTime(), message.getContent(), message.getTopicsList());
                    result = ResultUtil.buildPack(message.getUid(), true);
                } else {
                    result = ResultUtil.buildPack(message.getUid(), false);
                }
            }
            channelHandlerContext.channel().writeAndFlush(result);
        } else {
            channelHandlerContext.fireChannelRead(chatPack);
        }
    }

}
