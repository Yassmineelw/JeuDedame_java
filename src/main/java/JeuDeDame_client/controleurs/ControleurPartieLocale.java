package JeuDeDame_client.controleurs;

import JeuDeDame.modeles.partie_locale.PartieLocale;
import JeuDeDame.modeles.partie_locale.PartieLocaleLectureSeule;
import JeuDeDame_client.afficheurs.AfficheurPartieLocale;
import JeuDeDame_client.vues.VuePartieLocale;
import commun.debogage.J;

public abstract class ControleurPartieLocale<V extends VuePartieLocale, 
                                             A extends AfficheurPartieLocale<V>>

                extends ControleurPartie<PartieLocaleLectureSeule, 
                                         PartieLocale, 
                                         V, 
                                         A> {
	
	@Override
	protected void demarrer() {
		J.appel(this);
	}

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
		
		
	} 

	
}
