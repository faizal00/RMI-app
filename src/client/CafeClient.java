package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import interfacee.CafeInterface;

public class CafeClient {
    public static void main(String[] args) throws RemoteException,NotBoundException, MalformedURLException, IOException {
       // Tahap persiapan
       BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
       String user, pass, totalprice, kembalian;
       int pilihan, jumlah, uang;

       // Koneksi
       CafeInterface ci = (CafeInterface) Naming.lookup("rmi://127.0.0.1:271/Cafe");
       System.out.println("Terhubung...");

       // Aplikasi
       System.out.println("KAFE KOPI SENGON");
       System.out.println("=========================");
       System.out.println("User Name\t: ");
       user = input.readLine();
       System.out.println("Password\t: ");
       pass = input.readLine();

       if(ci.login(user, pass).equals("Berhasil Login")) {
           System.out.println("MENU:\n1 Americano\n2. Latte\n3. Cappuccino\n4. Espresso");
           System.out.println("Masukkan Pilihan\t: ");
           pilihan = Integer.parseInt(input.readLine());
           System.out.println("Masukkan Jumlah\t: ");
           jumlah = Integer.parseInt(input.readLine());

           totalprice = ci.menu(pilihan, jumlah);
           System.out.println("=========================");
           System.out.println("TOTAL BAYAR\t: " +totalprice);
           System.out.println("=========================");
           System.out.println("Masukkan Uang\t:");
           uang = Integer.parseInt(input.readLine());

           kembalian = ci.transaksiUser(uang, totalprice);
           System.out.println("Kembalian\t: " +kembalian);
    }
}
}
