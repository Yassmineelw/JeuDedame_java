package JeuDeDame_client.afficheurs;

import commun.debogage.J;   
import commun_client.mvc.Afficheur;
import JeuDeDame.modeles.sauvegardes.SauvegardesLectureSeule;
import JeuDeDame.modeles.sauvegardes.UneSauvegardeLectureSeule;
import JeuDeDame_client.vues.VueSauvegardes;
 

public abstract class AfficheurSauvegardes<V extends VueSauvegardes> 
       extends Afficheur<SauvegardesLectureSeule, V> {

	@Override
	public void initialiserAffichage(SauvegardesLectureSeule modeleLectureSeule, V vue) {
		J.appel(this);
		

		afficherLesSauvegardes(modeleLectureSeule, vue);
	}

	@Override
	public void rafraichirAffichage(SauvegardesLectureSeule modeleLectureSeule, V vue) {
		J.appel(this);
		
		vue.viderLesSauvegardes();
		
		afficherLesSauvegardes(modeleLectureSeule, vue);
	}

	private void afficherLesSauvegardes(SauvegardesLectureSeule modeleLectureSeule, V vue) {
		J.appel(this);
		
		for(UneSauvegardeLectureSeule uneSauvegarde : modeleLectureSeule.getLesSauvegardes()) {
			
			vue.ajouterSauvegarde(uneSauvegarde);
		}
	}
	

}
