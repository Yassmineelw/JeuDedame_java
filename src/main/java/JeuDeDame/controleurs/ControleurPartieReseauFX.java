package JeuDeDame.controleurs;

import JeuDeDame_client.controleurs.ControleurPartieReseau;
import commun.debogage.J;
import JeuDeDame.afficheurs.AfficheurPartieReseauFX;
import JeuDeDame.vues.VuePartieReseauFX;

public class   ControleurPartieReseauFX 

       extends ControleurPartieReseau<VuePartieReseauFX, 
                                      AfficheurPartieReseauFX> {
	@Override
	protected void obtenirMessagesPourEnvoi() {
	    J.appel(this);

	}

	@Override
	protected void installerReceptionMessages() {
	    J.appel(this);

	}


}
