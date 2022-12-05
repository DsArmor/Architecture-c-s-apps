import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends HelloImpl {

    public Server() {}

    public static void main(String[] args) {
        HelloImpl obj = new HelloImpl();
        try {
            Hello hub = (Hello) UnicastRemoteObject.exportObject(obj, 8090);

            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Solve", hub);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception " + e);
            e.printStackTrace();
        }
    }
}
