package com.cwzsmile.redis.socket.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/10/2 0002.
 */
public class CapEchoClient extends Thread{

    Socket server;
    Scanner key;

    public static void main(String[] args) {
        new CapEchoClient("127.0.0.1",4000).start();
    }

    public CapEchoClient(String ip, int port) {
        try {
            server = new Socket(ip, port);
            key = new Scanner(System.in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        DataInputStream istream = null;
        DataOutputStream ostream = null;
        try {
            istream = new DataInputStream(server.getInputStream());
            ostream = new DataOutputStream(server.getOutputStream());
            System.out.println(istream.readUTF());
            System.out.println(">");
            String tosend = key.nextLine();
            ostream.writeUTF(tosend);
            System.out.println(istream.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                istream.close();
                ostream.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
