package interfacee;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CafeInterface extends Remote{
    public String login(String user, String pass) throws RemoteException;
    public String menu(int opt, int qty) throws RemoteException;
    public String transaksiUser(int uangUser, String totalHarga) throws RemoteException;
}
