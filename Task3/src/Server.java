
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Server {
    private ServerSocket serverSocket;
    public List<String> messages;
    private List<EchoClientHandler> connections;
    private Timer timer;

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            messages = new ArrayList<>();
            timer = new Timer();
            connections = new ArrayList<>();
            while (true) {
                var connection = new EchoClientHandler(serverSocket.accept(), this);
                connections.add(connection);
                connection.start();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        sendMessages();
                    }
                }, 0, 5000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessages() {
        if (messages.isEmpty())
            return ;
        for (EchoClientHandler connection : connections) {
            for (String message : messages)
                connection.out.println(message);
        }
        messages.clear();
    }
}
