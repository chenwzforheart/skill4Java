package com.cwzsmile.redis.socket;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import java.io.InputStream;
import java.security.KeyStore;

/**
 * Created by Administrator on 2018/10/1 0001.
 */
public class TrustLoader {

    public static void main(String[] args) {
        try {
            InputStream stream = TrustLoader.class.getResourceAsStream("/ssl/rpgrenadesClient.jks");
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());

            char[] trustStorePassword = "password".toCharArray();
            trustStore.load(stream, trustStorePassword);

            SSLContext context = SSLContext.getInstance("SSL");
            TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            factory.init(trustStore);

            TrustManager[] managers = factory.getTrustManagers();
            context.init(null, managers, null);
            SSLContext.setDefault(context);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
