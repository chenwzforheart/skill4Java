package com.cwzsmile.redis.socket.multi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Created by Administrator on 2018/10/1 0001.
 */
public class Client {
    private MulticastSocket socket;

    public Client(String ip, int port) throws IOException {
        socket = new MulticastSocket();
        socket.joinGroup(InetAddress.getByName(ip));
    }

    public void printMessage() throws IOException {
        byte[] message = new byte[256];
        DatagramPacket packet = new DatagramPacket(message, message.length);

        socket.receive(packet);
        System.out.println(new String(packet.getData()));
    }

    public void close() {
        socket.close();
    }
}
