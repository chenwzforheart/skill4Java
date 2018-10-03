package com.cwzsmile.redis.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * Created by Administrator on 2018/10/2 0002.
 */
public class N {

    public static void main(String[] args) throws IOException{
        Selector sel = Selector.open();
        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(false);
        sc.setOption(StandardSocketOptions.SO_KEEPALIVE, true);

        sc.register(sel, SelectionKey.OP_CONNECT, "Connection to google.com");
        System.out.println("Initiating connection");
        if (sc.connect(new InetSocketAddress("www.baidu.com", 80))) {
            System.out.println("Connected");
        }
        else {
            boolean exist = false;
            while (!exist) {
                if (sel.select(100) == 0) {
                    continue;
                }
                Set<SelectionKey> keys = sel.selectedKeys();
                for (SelectionKey k : keys) {
                    System.out.println("Checking " + k.attachment());
                    if (k.isConnectable()) {
                        System.out.println("Connect through select() on " + k.channel()+" ->");
                        if (sc.finishConnect()) {
                            System.out.println("done!");
                            k.interestOps(k.interestOps() & ~SelectionKey.OP_CONNECT);
                            exist = true;
                        } else {
                            System.out.println("unfinished");
                        }
                    }
                    //todo else if (k.isReadable)

                }
                keys.clear();
            }
        }
        System.out.println("Disconnecting ... ");
        sc.shutdownOutput();
        sc.close();
        System.out.println("done");
    }
}
