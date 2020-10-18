package com.leo.chat;


import com.leo.chat.handler.*;
import com.leo.chat.proto.ChatPackOuterClass;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Server {

    public static void main(String args[]) throws InterruptedException {
        NioEventLoopGroup parentGroup = new NioEventLoopGroup();
        NioEventLoopGroup childGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(parentGroup, childGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChannelInitializer<NioSocketChannel>() {
                        protected void initChannel(NioSocketChannel ch) throws Exception {
                            ch.pipeline()
                                    .addLast(new HttpServerCodec())
                                    .addLast(new ChunkedWriteHandler())
                                    .addLast(new HttpObjectAggregator(1024 * 64))
                                    .addLast(new WebSocketServerProtocolHandler("/ws", null, true))
//                                    .addLast("idleEventTrigger", new IdleStateHandler(2, 0 , 0, TimeUnit.SECONDS))
//                                    .addLast("idleDestroy", new IdleDestroyHandler(5))
                                    .addLast(new WebSocketServerCompressionHandler())
                                    .addLast("websocketBinaryFrameDecoder", new WebSocketFrameDecode())
                                    .addLast("websocketBinaryFrameEncoder", new WebSocketFrameEncoder())
//                                    .addLast("protoBufferFrameDecoder", new ProtobufVarint32FrameDecoder())
//                                    .addLast("chatPackDecoder", new ProtobufDecoder(ChatPackOuterClass.ChatPack.getDefaultInstance()))
//                                    .addLast("protoBufferFrameLengthAppender", new ProtobufVarint32LengthFieldPrepender())
                                    .addLast("protoBufferEncoder", new ProtoBufferFrameEncoder())
                                    .addLast("testWriter", new TestWriterHandler())
                                    .addLast("message", new MessageHandler())
                                    .addLast("subscribe", new SubscribeHandler())
                                    .addLast("unsubscribe", new UnSubscribeHandler())
                            ;
                        }
                    });
            ChannelFuture acceptFuture = serverBootstrap.bind(9001).sync();
            log.info("服务器监听9001中");
            acceptFuture.channel().closeFuture().sync();
        } finally {
            parentGroup.shutdownGracefully();
            childGroup.shutdownGracefully();
        }
    }

}
