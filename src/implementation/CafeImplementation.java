package implementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import interfacee.CafeInterface;

public class CafeImplementation extends UnicastRemoteObject implements CafeInterface{
    public CafeImplementation() throws RemoteException{

    }

    @Override
    public String login(String user, String pass) throws RemoteException {
        try {
            if(user.equals("kasir") && pass.equals("kasir")){
                return "Berhasil Login";
            } else {
                return "User Name Atau Password Anda Salah";
            }
        } catch (Exception e) {
            // TODO: handle exception
            return "Error : "+e.toString();
        }
    }

    @Override
    public String menu(int opt, int qty) throws RemoteException {
        try {
            int totalprice = 0;
            if(opt == 1) {
                totalprice += (20000 * qty);
                return "" + totalprice;
            } else if(opt == 2) {
                totalprice += (20000 * qty);
                return "" + totalprice;
            } else if(opt == 3) {
                totalprice += (20000 * qty);
                return "" + totalprice;
            } else if(opt == 4) {
                totalprice += (20000 * qty);
                return "" + totalprice;
            } else {
                return "PILIHAN TIDAK TERSEDIA";
            }
        } catch (Exception e) {
            // TODO: handle exception
            return "Error : "+e.toString();
        }
    }

    @Override
    public String transaksiUser(int uangUser, String totalHarga) throws RemoteException {
        try {
            int total = Integer.parseInt(totalHarga);
            if(uangUser >= total) {
                return "" + (uangUser - total);
            } else {
                return "UANG ANDA TIDAK CUKUP";
            }
        } catch (Exception e) {
            // TODO: handle exception
            return "Error : "+e.toString();
        }
    }


}