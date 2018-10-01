package com.cwzsmile.redis.socket.multi;

import java.io.IOException;
import java.net.*;

/**
 * Created by Administrator on 2018/10/1 0001.
 */
public class Server {

    private DatagramSocket serverSocket;
    private String ip;
    private int port;

    public Server(String ip, int port) throws SocketException {
        this.ip = ip;
        this.port = port;
        serverSocket = new DatagramSocket();
    }

    public void send() throws IOException {
        byte[] message = "Multicasting".getBytes();
        DatagramPacket packet = new DatagramPacket(message, message.length, InetAddress.getByName(ip), port);
        serverSocket.send(packet);
    }

    public void close() {
        serverSocket.close();
    }
}
