package com.leo.chat.handler;

import com.leo.chat.manager.ChannelGround;
import com.leo.chat.proto.ChatPackOuterClass;
import com.leo.chat.proto.data.ResultOuterClass;
import com.leo.chat.proto.data.SubscribeOuterClass;
import com.leo.chat.proto.data.UnSubscribeOuterClass;
import com.leo.chat.util.ResultUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class UnSubscribeHandler extends SimpleChannelInboundHandler<ChatPackOuterClass.ChatPack> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ChatPackOuterClass.ChatPack chatPack) throws Exception {
        if (ChatPackOuterClass.ChatPack.DataCase.UNSUBSCRIBE.equals(chatPack.getDataCase())) {
            Channel channel = channelHandlerContext.channel();
            UnSubscribeOuterClass.UnSubscribe unsubscribe = chatPack.getUnsubscribe();
            if (unsubscribe.getTopicsList() != null && !unsubscribe.getTopicsList().isEmpty()) {
                ChannelGround.unsubscribe(unsubscribe.getTopicsList(), channel);
            }
            ChatPackOuterClass.ChatPack result = ResultUtil.buildPack(unsubscribe.getUid(), false);;
            channelHandlerContext.channel().writeAndFlush(result);
        } else {
            channelHandlerContext.fireChannelRead(chatPack);
        }
    }





}
