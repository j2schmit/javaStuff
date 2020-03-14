package com.adv.java.networking.streamurl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class StreamUrl {

    private String host;

    public StreamUrl(String host) {
        this.host = host;
    }

    public InputStream getUrlInputStream() throws IOException {
        System.out.println("Opening URL connection to :");
        System.out.println(host + "\n");
        URL url = new URL(host);
        URLConnection conn = url.openConnection();

        return conn.getInputStream();
    }


}
