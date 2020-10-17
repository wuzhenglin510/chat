package com.leo.chat;


import com.chat.handler.DispatcherHandler;
import com.chat.handler.IdleDestroyHandler;
import com.chat.handler.RetryConnectHandler;
import com.chat.proto.TopLevelDataOuterClass;
import com.leo.chat.handler.IdleDestroyHandler;
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
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

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
                            System.out.println("链路建立");
                            ch.pipeline()
                                    .addLast(new HttpServerCodec())
                                    .addLast(new ChunkedWriteHandler())
                                    .addLast(new HttpObjectAggregator(1024 * 64))
                                    .addLast(new WebSocketServerProtocolHandler("/ws"))
                                    .addLast("frameLengthReader", new ProtobufVarint32FrameDecoder())
                                    .addLast("decoder", new ProtobufDecoder(ChatPackOuterClass.ChatPack.getDefaultInstance()))
//                                    .addLast("retryConnect", new RetryConnectHandler())
                                    .addLast("idleEventTrigger", new IdleStateHandler(2, 0 , 0, TimeUnit.SECONDS))
                                    .addLast("idleDestroy", new IdleDestroyHandler(5))
                                    .addLast("frameLengthWriter", new ProtobufVarint32LengthFieldPrepender())
                                    .addLast("encoder", new ProtobufEncoder());
//                                    .addLast("dispatcher", new DispatcherHandler());
                        }
                    });
            ChannelFuture acceptFuture = serverBootstrap.bind(9001).sync();
            acceptFuture.channel().closeFuture().sync();
        } finally {
            parentGroup.shutdownGracefully();
            childGroup.shutdownGracefully();
        }
    }

}
