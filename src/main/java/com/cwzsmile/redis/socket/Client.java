package com.cwzsmile.redis.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Created by Administrator on 2018/9/30 0030.
 */
public class Client {

    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("127.0.0.1", 1234);

        OutputStream outputStream = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
        writer.println("Hello world");
        writer.flush();
    }
}
