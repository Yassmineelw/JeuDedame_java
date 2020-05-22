package ouvrir_sauvegarde;

import commun.debogage.J;  
import commun_client.commandes.Commande;
import ouvrir_sauvegarde.OuvrirSauvegardePourEnvoi;
import ouvrir_sauvegarde.OuvrirSauvegardeRecue;

public class OuvrirSauvegarde 
       extends    Commande<OuvrirSauvegardePourEnvoi,
                        OuvrirSauvegardeRecue>
	   implements OuvrirSauvegardePourEnvoi,
	              OuvrirSauvegardeRecue {
	
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
