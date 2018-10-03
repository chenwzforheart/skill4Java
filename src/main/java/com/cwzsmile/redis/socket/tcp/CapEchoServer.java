package com.cwzsmile.redis.socket.tcp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2018/10/2 0002.
 */
public class CapEchoServer extends Thread {

    public static void main(String[] args) {
        new CapEchoServer(4000,10000).start();
    }
    private Logger logger = LoggerFactory.getLogger(CapEchoServer.class);

    ServerSocket serverSocket;

    public CapEchoServer(int port, int timeout) {
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(timeout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
            /*while (!Thread.interrupted()) {

            }
            serverSocket.close();*/
                logger.info("Listening for Clients at {} on {}", serverSocket.getLocalPort(), InetAddress.getLocalHost().getHostAddress());
                Socket client = serverSocket.accept();
                DataInputStream istream = new DataInputStream(client.getInputStream());
                DataOutputStream ostream = new DataOutputStream(client.getOutputStream());

                ostream.writeUTF("Welcome!");

                String inString = istream.readUTF();
                String outString = inString.toUpperCase();
                ostream.writeUTF(outString);

                istream.close();
                ostream.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
