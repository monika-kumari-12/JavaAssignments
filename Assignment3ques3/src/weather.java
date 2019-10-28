import java.rmi.*;

public interface weather extends Remote {
    public int weatherInfo(int city) throws RemoteException;
}
