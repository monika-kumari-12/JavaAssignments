import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
public class server extends UnicastRemoteObject implements weather{
    public server() throws RemoteException{
       // super();
    }
    public int weatherInfo(int city) throws RemoteException{
        int temp;
        if(city ==1)
        { temp = 34;}
        else if(city==2)
        { temp = 29;}
        else temp= -1;
        return temp;
    }
    public static void main(String[] args) throws RemoteException{
        try{
            Registry reg=LocateRegistry.createRegistry(9979);
            reg.rebind("Hi Server",new server());
            System.out.println("Server is ready");
        }
        catch(RemoteException e){
            System.out.println("exception" + e);
        }
    }
}
