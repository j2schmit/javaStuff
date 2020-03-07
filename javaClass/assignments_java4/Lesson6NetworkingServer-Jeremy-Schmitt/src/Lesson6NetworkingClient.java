import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Lesson6NetworkingClient {
    public static void main(String[] args) throws IOException {
        String address = "";
        int port = 0;

        if (args.length != 4){
            displayHelpMessage();
            System.exit(1);
        }

        for (int idx = 0; idx < args.length; idx++) {
            String cmd = args[idx];
            switch (cmd) {
                case "--port":
                    port = Integer.parseInt(args[++idx]);
                    break;
                case "--server":
                    address = args[++idx];
                    break;
                default:
                    displayHelpMessage();
                    System.exit(1);
            }
        }

        Socket socket = new Socket(address, port);
        Scanner in = new Scanner(socket.getInputStream(), "UTF-8");
        while (in.hasNextLine()) {
            String line = in.nextLine();
            System.out.println(line);
        }
    }

    private static void displayHelpMessage() {
        String helpMsg = "";
        helpMsg += "--server <address> --port <port #>  (REQUIRED)\n";
        System.out.println(helpMsg);
    }
}
