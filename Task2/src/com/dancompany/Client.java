import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    private Client () {}

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            Equation eq = new Equation(in.nextDouble(), in.nextDouble(), in.nextDouble());

            Registry registry = LocateRegistry.getRegistry(null);
            Hello hub = (Hello) registry.lookup("Solve");
            Solution sol = hub.solve(eq);

            System.out.println(eq.a + "*x^2 + " + eq.b + "*x + " + eq.c + " = 0");
            if (sol.solution) {
                if (!sol.infinite)
                    System.out.println(sol.roots);
                else
                    System.out.println("Infinite number of solutions");
            } else
                System.out.println("There are no solutions");
        } catch (Exception e) {
            System.err.println("Client error" + e);
            e.printStackTrace();
        }
    }
}
