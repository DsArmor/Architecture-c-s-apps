
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
    Solution solve(Equation equation) throws RemoteException;
}
