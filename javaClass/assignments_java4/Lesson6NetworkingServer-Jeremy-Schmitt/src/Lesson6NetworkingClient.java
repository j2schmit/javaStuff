import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Lesson6NetworkingClient {
    public static void main(String[] args) throws IOException {
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        Socket socket = new Socket(host, port);
        Scanner in = new Scanner(socket.getInputStream(), "UTF-8");
        while (in.hasNextLine()) {
            String line = in.nextLine();
            System.out.println(line);
        }
    }
}
