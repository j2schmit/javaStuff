package com.adv.java.iostream;

import java.io.*;

public class IOStream {

    public static void xMLInputStreamToFile(InputStream inputStream, String file) throws IOException {
        System.out.println("Writing to file:");
        System.out.println(file + "\n");

        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line = null;

        while ((line = bufferedReader.readLine()) != null) {
            writer.write(line);
        }

        reader.close();
        writer.close();
    }
}
