package com.cwzsmile.redis.socket.multi;

import java.io.IOException;

/**
 * Created by Administrator on 2018/10/1 0001.
 */
public class CServer {
    public static void main(String[] args) {
        try {
            String ip = args[0];
            int port = Integer.parseInt(args[1]);
            Client client = new Client(ip, port);
            client.printMessage();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
