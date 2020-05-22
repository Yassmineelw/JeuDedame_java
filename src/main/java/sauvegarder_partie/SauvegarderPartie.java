package sauvegarder_partie;

import commun.debogage.J; 
import commun_client.commandes.Commande;
import sauvegarder_partie.SauvegarderPartiePourEnvoi;
import sauvegarder_partie.SauvegarderPartieRecue;

public class SauvegarderPartie 
       extends    Commande<SauvegarderPartiePourEnvoi,
                        SauvegarderPartieRecue>
	   implements SauvegarderPartiePourEnvoi,
	              SauvegarderPartieRecue {
	
	private String cheminDansHome;

	@Override
	public String getCheminDansHome() {
		J.appel(this);
		
		return cheminDansHome;
	}

	@Override
	public void setCheminDansHome(String cheminDansHome) {
		J.appel(this);
		
		this.cheminDansHome = cheminDansHome;
	}

}
