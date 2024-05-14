package server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import implementation.CafeImplementation;

public class CafeServer {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.createRegistry(271);
        CafeImplementation ci = new CafeImplementation();
        reg.rebind("Cafe", ci);
        System.out.println("Server Berjalan");
    }
}
