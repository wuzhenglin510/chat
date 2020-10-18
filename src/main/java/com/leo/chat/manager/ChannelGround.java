package com.leo.chat.manager;

import com.google.protobuf.ProtocolStringList;
import com.leo.chat.proto.ChatPackOuterClass;
import com.leo.chat.proto.data.MessageOuterClass;
import com.leo.chat.proto.data.ResultOuterClass;
import io.netty.channel.Channel;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ChannelGround {

    /**
     * key: 订阅topic
     * value: 订阅了这个topic的 Channel集合
     */
    private final static ConcurrentHashMap<String, ConcurrentHashMap<Channel, Boolean>> topicChannelsMaps = new ConcurrentHashMap<String, ConcurrentHashMap<Channel, Boolean>>(1024);

    /**
     * key: channel
     * values: 这个channel订阅了哪些topic
     */
    private final static ConcurrentHashMap<Channel, HashSet<String>> channelSubscribedTopics = new ConcurrentHashMap<Channel, HashSet<String>>(1024) ;

    /**
     * 监听多个的topic
     * @param topics
     * @param channel
     */
    public static void subscribe(List<String> topics, Channel channel) {
        for (String topic : topics) {
            subscribe(topic, channel);
        }
    }

    /**
     * 监听单个topic
     * @param topic
     * @param channel
     */
    private static void subscribe(String topic, Channel channel) {
        if (!topicChannelsMaps.contains(topic)) {
             synchronized (ChannelGround.class) {
                 if (!topicChannelsMaps.contains(topic)) {
                     topicChannelsMaps.put(topic, new ConcurrentHashMap<Channel, Boolean>());
                 }
             }
        }
        ConcurrentHashMap<Channel, Boolean> topicChannels = topicChannelsMaps.get(topic);
        if (!topicChannels.contains(channel)) {
            topicChannels.put(channel, true);
        }
    }


    /**
     * channel取消监听指定topic
     * @param topics
     * @param channel
     */
    public static void unsubscribe(List<String> topics, Channel channel) {
        if (channelSubscribedTopics.contains(channel)) {
            for (String topic : topics) {
                unsubscribe(topic, channel);
            }
        }
    }

    /**
     * channel取消监听单个topic
     * @param topic
     * @param channel
     */
    private static void unsubscribe(String topic, Channel channel) {
        if (topicChannelsMaps.contains(topic)) {
            ConcurrentHashMap<Channel, Boolean> topicChannels = topicChannelsMaps.get(topic);
            if (topicChannels.contains(channel)) {
                topicChannels.remove(channel);
            }
        }
    }

    public static boolean checkHasSubscribe(List<String> topics, Channel channel) {
        if (channelSubscribedTopics.contains(channel)) {
            HashSet<String> subscribedTopics = channelSubscribedTopics.get(channel);
            return subscribedTopics.contains(topics);
        } else {
            return false;
        }
    }

    public static void sendMessage(String uid, long sendTime, String content, ProtocolStringList topics) {
        ChatPackOuterClass.ChatPack chatPack = ChatPackOuterClass.ChatPack.newBuilder()
                .setType(ChatPackOuterClass.ChatPack.Type.MESSAGE)
                .setMessage(MessageOuterClass.Message.newBuilder()
                        .setUid(uid)
                        .setSendTime(sendTime)
                        .setContent(content))
                .build();
        for (String topic : topics) {
            if (topicChannelsMaps.contains(topic)) {
                ConcurrentHashMap<Channel, Boolean> channels = topicChannelsMaps.get(topic);
                for (Channel channel : channels.keySet()) {
                    channel.writeAndFlush(chatPack);
                }
            }
        }
    }
}
