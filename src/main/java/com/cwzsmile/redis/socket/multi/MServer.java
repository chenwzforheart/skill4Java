package com.cwzsmile.redis.socket.multi;

import java.io.IOException;

/**
 * Created by Administrator on 2018/10/1 0001.
 */
public class MServer {
    public static void main(String[] args) {
        try {
            String ip = args[0];
            int port = Integer.parseInt(args[1]);
            Server server = new Server(ip, port);
            server.send();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
