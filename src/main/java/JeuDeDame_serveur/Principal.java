package JeuDeDame_serveur;

import commun.debogage.J; 
import static JeuDeDame.Constantes.*;

public class Principal {
	
	public static void main(String[] args) {
		J.appel(Principal.class);
		
		demarrerServeur();
	}
	
	private static void demarrerServeur() {
		J.appel(Principal.class);
		
		ServeurJeuDeDame serveur = new ServeurJeuDeDame(PORT);
		serveur.start();
	}

}
