import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Lesson6NetworkingServer {
    public static void main(String[] args) throws IOException {
        int port = 0;

        if (args.length != 2){
            displayHelpMessage();
            System.exit(1);
        }

        for (int idx = 0; idx < args.length; idx++) {
            String cmd = args[idx];
            switch (cmd) {
                case "--port":
                    port = Integer.parseInt(args[++idx]);
                    break;
                default:
                    displayHelpMessage();
                    System.exit(1);
            }
        }

        try (ServerSocket s = new ServerSocket(port)) {
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

    private static void displayHelpMessage() {
        String helpMsg = "";
        helpMsg += "--port <port #>  (REQUIRED)\n";
        System.out.println(helpMsg);
    }
}
