package JeuDeDame.controleurs;

import JeuDeDame_client.controleurs.ControleurPartieLocale;
import commun.debogage.J;
import JeuDeDame.afficheurs.AfficheurPartieLocaleFX;
import JeuDeDame.vues.VuePartieLocaleFX;

public class   ControleurPartieLocaleFX 

       extends ControleurPartieLocale<VuePartieLocaleFX, 
                                      AfficheurPartieLocaleFX> {
	@Override
	protected void obtenirMessagesPourEnvoi() {
	    J.appel(this);

	}

	@Override
	protected void installerReceptionMessages() {
	    J.appel(this);

	}

}
