package com.cwzsmile.redis.socket;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/**
 * Created by Administrator on 2018/10/1 0001.
 */
public class Down {
    public static void main(String[] args) {
        String fileName = "file.zip";
        String urlToGetFrom = "http://mywebsite.com/";
        String pathToSaveTo = "C:\\Users\\user\\";

        try (ReadableByteChannel rbc = Channels.newChannel(new URL(urlToGetFrom + fileName).openStream())) {
            try (FileChannel channel = new FileOutputStream(pathToSaveTo + fileName).getChannel();) {
                channel.transferFrom(rbc, 0, Long.MAX_VALUE);
            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            }
        } catch (MalformedURLException e) {

        } catch (IOException e) {

        }
    }
}
