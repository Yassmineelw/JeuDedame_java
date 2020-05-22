package JeuDeDame_client.afficheurs;

import JeuDeDame.modeles.partie_locale.PartieLocaleLectureSeule;  
import JeuDeDame_client.vues.VuePartieLocale;
import commun.debogage.J;
 
public abstract class   AfficheurPartieLocale<V extends VuePartieLocale>

                extends AfficheurPartie<PartieLocaleLectureSeule, V>  {
	
    @Override
    public void initialiserAffichage(PartieLocaleLectureSeule partieLectureSeule, VuePartieLocale vue) {
        J.appel(this);
 
		
		 
		rafraichirAffichage(partieLectureSeule, vue);
    }

    @Override
    public void rafraichirAffichage(PartieLocaleLectureSeule partieLectureSeule, VuePartieLocale vue) {
        J.appel(this);

    }


}
