import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Lesson6NetworkingServer {
    public static void main(String[] args) throws IOException {
        // expects args "--port <port #>", i.e. "--port 8189"
        int port = Integer.parseInt(args[1]);

        try (ServerSocket s = new ServerSocket(port)) {
            // Wait for client
            try (Socket incoming = s.accept()) {
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();
                try (Scanner in = new Scanner(inStream, "UTF-8")) {
                    PrintWriter out = new PrintWriter(
                            new OutputStreamWriter(outStream, "UTF-8"),true);
                    out.println("HTTP/1.0 200 OK\n" +
                            "Content-Type: text/html\n" +
                            "\n" +
                            "\n" +
                            "<html>\n" +
                            "<head><title>Java Networking</title></head>\n" +
                            "<body>\n" +
                            "<h1>Java Networking</h1>\n" +
                            "</body>\n" +
                            "</html>");
                }
            }
        }
    }
}
