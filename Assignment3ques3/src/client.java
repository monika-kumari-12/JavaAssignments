import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
public class client {
    public static void main(String[] args) throws RemoteException {
        
        client c= new client();
        c.connectRemote();
    }

    private void connectRemote() throws RemoteException {
        try{
            Scanner sc = new Scanner(System.in);
            Registry reg =LocateRegistry.getRegistry("localhost",9979);
            weather weath= (weather)reg.lookup("Hi Server");
            System.out.println("Enter the city code : 1. Delhi  2. Mumbai");
            int ci =sc.nextInt();
            System.out.println("temperature is " + weath.weatherInfo(ci));
        }
        catch (NotBoundException|RemoteException e){
            System.out.println("Exception" + e);
        }
    }
}
