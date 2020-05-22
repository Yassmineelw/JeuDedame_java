package JeuDeDame_client.afficheurs; 

import commun.debogage.J;  
import commun_client.mvc.Afficheur;
import JeuDeDame.modeles.parametres.ParametresLectureSeule;
import JeuDeDame_client.vues.VueParametres;

public abstract class AfficheurParametres<V extends VueParametres> 

                            extends Afficheur<ParametresLectureSeule, 
                                              V> {

	@Override
	public void initialiserAffichage(ParametresLectureSeule modeleLectureSeule, VueParametres vue) {
		J.appel(this);
		
		

	}

	@Override
	public void rafraichirAffichage(ParametresLectureSeule modeleLectureSeule, VueParametres vue) {
		J.appel(this);
		
	

	}

}
