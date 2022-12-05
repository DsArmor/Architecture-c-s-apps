import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("Enter message");
            Scanner scanner = new Scanner(System.in);
            Thread thread = new Thread(() -> {
                while (true)
                    getMessage();
            });
            thread.start();
            while (true) {
                String cmd = scanner.nextLine();
                sendMessage(cmd);
            }
        } catch (IOException e) {
            stopConnection();
            e.printStackTrace();
        }
    }

    public void getMessage() {
        String message;
        while (true) {
            try {
                message = in.readLine();
                System.out.println("Message: " + message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message) {
        try {
            out.println(message);
        } catch (Exception e) {
            stopConnection();
        }
    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}