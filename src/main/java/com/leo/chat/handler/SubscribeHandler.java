package com.leo.chat.handler;

import com.leo.chat.manager.ChannelGround;
import com.leo.chat.proto.ChatPackOuterClass;
import com.leo.chat.proto.data.ResultOuterClass;
import com.leo.chat.proto.data.SubscribeOuterClass;
import com.leo.chat.util.ResultUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class SubscribeHandler extends SimpleChannelInboundHandler<ChatPackOuterClass.ChatPack> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ChatPackOuterClass.ChatPack chatPack) throws Exception {
        if (ChatPackOuterClass.ChatPack.DataCase.SUBSCRIBE.equals(chatPack.getDataCase())) {
            ChatPackOuterClass.ChatPack result = null;
            Channel channel = channelHandlerContext.channel();
            SubscribeOuterClass.Subscribe subscribe = chatPack.getSubscribe();
            if (subscribe.getTopicsList() != null && !subscribe.getTopicsList().isEmpty()) {
                //这里需要解密ticket, 看是否有权限监听这些topics
                if (true) {
                    ChannelGround.subscribe(subscribe.getTopicsList(), channel);
                    result = ResultUtil.buildPack(subscribe.getUid(), true);
                } else {
                    result = ResultUtil.buildPack(subscribe.getUid(), false);
                }
            }
            channelHandlerContext.channel().writeAndFlush(result);
        } else {
            channelHandlerContext.fireChannelRead(chatPack);
        }
    }
}
