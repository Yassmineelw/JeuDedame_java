package JeuDeDame_client.controleurs;

import commun.debogage.J; 
import commun_client.mvc.controleurs.ControleurModeleVue;
import JeuDeDame.modeles.partie_locale.PartieLocale;
import JeuDeDame.modeles.partie_locale.PartieLocaleLectureSeule;
import JeuDeDame_client.afficheurs.AfficheurPartieLocale;

import JeuDeDame_client.vues.VuePartieLocale;

public abstract class ControleurPartieLocale<V extends VuePartieLocale,
					       				     A extends AfficheurPartieLocale<V>> 

					extends ControleurModeleVue<PartieLocaleLectureSeule, 
											    PartieLocale, V, 
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
