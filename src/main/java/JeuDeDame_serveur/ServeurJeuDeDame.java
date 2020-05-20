package JeuDeDame_serveur;

import commun.debogage.J; 
import commun_serveur.ServeurWebSocket;

public class ServeurJeuDeDame extends ServeurWebSocket {

	public ServeurJeuDeDame(int port) {
		super(port);
		J.appel(this);
	}

	
}
