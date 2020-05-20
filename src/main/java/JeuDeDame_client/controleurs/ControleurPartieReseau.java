package JeuDeDame_client.controleurs;

 
import JeuDeDame.modeles.partie_reseau.PartieReseau;
import JeuDeDame.modeles.partie_reseau.PartieReseauLectureSeule;
import JeuDeDame_client.afficheurs.AfficheurPartieReseau;
import JeuDeDame_client.vues.VuePartieReseau;

public abstract class ControleurPartieReseau<V extends VuePartieReseau, 
                                             A extends AfficheurPartieReseau<V>>

                extends ControleurPartie<PartieReseauLectureSeule, 
                        PartieReseau, 
                        V, 
                        A> {
	
	
	
}
