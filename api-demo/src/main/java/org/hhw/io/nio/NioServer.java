package org.hhw.io.nio;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class NioServer {
    private static int PORT = 9999;
    public static void main(String[] args) {
        try {
            //先建立通道
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //设置告诉公路的关卡
            serverSocketChannel.bind(new InetSocketAddress(PORT));
            serverSocketChannel.configureBlocking(false);

            //排队叫号
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while(true) {
                int wait = selector.select();
                if(wait == 0) {
                    continue;
                }

                Set<SelectionKey> keys = selector.selectedKeys();
                for(SelectionKey key : keys) {
                    keys.remove(key);  //TODO 这句话表示疑问
                    //处理逻辑
                    if(key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel client = server.accept();
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_READ);

                        key.interestOps(SelectionKey.OP_ACCEPT);
                        client.write(new ByteBuffer[5]);
                    }

                    if(key.isReadable()) {
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        StringBuilder builder = new StringBuilder();

                        try{
                            while (client.read(buffer) > 0) {
                                buffer.flip();
                                builder.append(buffer);
                            }

                            key.interestOps(SelectionKey.OP_READ);
                        } catch (IOException e) {

                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
