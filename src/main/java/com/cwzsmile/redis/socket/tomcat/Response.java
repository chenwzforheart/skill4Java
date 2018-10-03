package com.cwzsmile.redis.socket.tomcat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Administrator on 2018/10/3 0003.
 */
public class Response {
    private static final String HEADER = "HTTP/1.1 200 OK\r\n" +
            "Date: Wed, 03 Oct 2018 07:30:17 GMT\r\n" +
            "Content-Type: text/html; charset=UTF-8\r\n" +
            "Connection: keep-alive\r\n" +
            "Server: squid/3.5.24\r\n\r\n";
    private static final int BUFFER_SIZE = 1024;
    Request request;
    OutputStream output;


    public Response(OutputStream output) {
        this.output = output;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void sendStaticResource() throws IOException{
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        File file = new File(HttpServer.WEB_ROOT, request.getUri());
        if (file.exists()) {
            fis = new FileInputStream(file);
            int ch = fis.read(bytes, 0, BUFFER_SIZE);
            //1.读头部
            byte[] hh = HEADER.getBytes();
            output.write(hh,0,hh.length);
            while (ch != -1) {
                output.write(bytes,0,ch);
                ch = fis.read(bytes, 0, BUFFER_SIZE);
            }
        }else {
            String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
                    "Content-Type:text/html\r\n"+
                    "Content-Length:23\r\n"+
                    "\r\n"+
                    "<h1>File Not Found</h1>";
            output.write(errorMessage.getBytes());
        }
        if (fis != null) {
            fis.close();
        }
    }
}
