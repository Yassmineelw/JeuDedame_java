package JeuDeDame_client.afficheurs; 

 import JeuDeDame.modeles.partie_reseau.PartieReseauLectureSeule;
 import JeuDeDame_client.vues.VuePartieReseau;
 
public abstract class   AfficheurPartieReseau<V extends VuePartieReseau>

                extends AfficheurPartie<PartieReseauLectureSeule, V>  {
	

}
