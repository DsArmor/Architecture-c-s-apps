import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoClientHandler extends Thread {
    private Server server;
    private Socket socket;

    public PrintWriter out;
    public BufferedReader in;

    public EchoClientHandler(Socket socket, Server server) {
        this.server = server;
        this.socket = socket;
    }

    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String message = in.readLine();
                System.out.println("Message " + message + " from " + socket.getRemoteSocketAddress());
                server.messages.add(message);
            }

        } catch (IOException e) {
            stopConnection();
        }
    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
