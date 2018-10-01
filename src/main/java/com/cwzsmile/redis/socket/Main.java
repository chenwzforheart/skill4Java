package com.cwzsmile.redis.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by Administrator on 2018/10/1 0001.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("baidu.com", 80);

        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(outputStream));

        writer.print("GET / HTTP/1.1\nHost:baidu.com\n\n");
        writer.flush();

        System.out.println(readFully(reader));

        socket.close();
    }

    private static String readFully(Reader in) throws IOException{
        StringBuilder sb = new StringBuilder();
        int BUFFER_SIZE = 1024;
        char[] buffer = new char[BUFFER_SIZE];
        int charsRead = 0;
        while ((charsRead = in.read(buffer, 0, BUFFER_SIZE)) != -1) {
            sb.append(buffer, 0, charsRead);
        }
        return sb.toString();
    }
}
