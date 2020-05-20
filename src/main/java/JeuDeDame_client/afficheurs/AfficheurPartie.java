package JeuDeDame_client.afficheurs;

import commun.debogage.J;
import commun_client.mvc.Afficheur;

import JeuDeDame.modeles.partie.PartieLectureSeule;
import JeuDeDame_client.vues.VuePartie;

public abstract class   AfficheurPartie<PLS extends PartieLectureSeule, 
                                        V extends VuePartie> 

				extends Afficheur<PLS, V> {
	@Override
	public void initialiserAffichage(PLS modeleLectureSeule, V vue) {
	    J.appel(this);

	}

	@Override
	public void rafraichirAffichage(PLS modeleLectureSeule, V vue) {
	    J.appel(this);

	}
	
}
