package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class ChatRoomImpl extends UnicastRemoteObject implements ChatRoom {

	ArrayList<String> utilisateurs;
	String msg_courant;
	protected ChatRoomImpl() throws RemoteException {
		super();
		utilisateurs = new ArrayList<String>();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4174498417430362926L;

	@Override
	public boolean subscribe(String pseudo) throws RemoteException {
		if(!utilisateurs.contains(pseudo)){
			utilisateurs.add(pseudo);
			this.postMessage(pseudo, "connected");
			return true;
		} 
		return false;
	}

	@Override
	public void unsubscribe(String pseudo) throws RemoteException {
		String message = pseudo+" disconnected";
		if(utilisateurs.contains(pseudo)) {
			utilisateurs.remove(pseudo);
			this.postMessage(pseudo, message);
		}
	}

	@Override
	public void postMessage(String pseudo, String message) throws RemoteException {
		String messageEntier = pseudo+" >>>> "+message;
		System.out.println(messageEntier);
        	msg_courant = messageEntier;
	}
	
	@Override
	public String getMessage() {
		return this.msg_courant;
	}
}
