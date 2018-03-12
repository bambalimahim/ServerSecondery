package rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class Serveur {

	public static void main(String[] args) {
		try{
			LocateRegistry.createRegistry(1099);
			//instanciation d'un objet de la classe distante
			ChatRoomImpl chatRoomImpl = new ChatRoomImpl();
			Naming.rebind("rmi://localhost:1099/TP", chatRoomImpl);
			System.out.println("Serveur lancé");
			System.out.println(java.net.InetAddress.getLocalHost());
			System.out.println(chatRoomImpl.toString());
		}catch(RemoteException e){
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}