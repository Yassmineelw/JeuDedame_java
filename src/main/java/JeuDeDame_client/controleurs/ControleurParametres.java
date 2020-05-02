package JeuDeDame_client.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.ControleurModeleVue;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import JeuDeDame.modeles.parametres.Parametres;
import JeuDeDame.modeles.parametres.ParametresLectureSeule;
import JeuDeDame_client.afficheurs.AfficheurParametres;

import JeuDeDame_client.vues.VueParametres;

public abstract class ControleurParametres<V extends VueParametres,
					       				     A extends AfficheurParametres<V>> 

					extends ControleurModeleVue<ParametresLectureSeule, 
											    Parametres, 
											    V, 
											    A> {
	

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
		
	}

	@Override
	protected void demarrer() {
		J.appel(this);

	} 
}
