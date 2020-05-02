package JeuDeDame.controleurs;

import commun.debogage.J;
import commun.systeme.Systeme;
import commun_client.commandes.FabriqueCommande;
import commun_client.commandes.RecepteurCommande;
import commun_client.mvc.controleurs.FabriqueControleur;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import commun_javafx.ChargeurDeVue;
import commun_javafx.DialogueModal;
import javafx.scene.Scene;
import javafx.stage.Stage;
import JeuDeDame.modeles.parametres.Parametres;
import JeuDeDame.modeles.parametres.ParametresLectureSeule;
import JeuDeDame.modeles.partie_locale.PartieLocale;
import JeuDeDame_client.commandes.nouvelle_partie.NouvellePartie;
import JeuDeDame_client.commandes.nouvelle_partie.NouvellePartieRecue;
import JeuDeDame_client.commandes.ouvrir_parametres.OuvrirParametres;
import JeuDeDame_client.commandes.ouvrir_parametres.OuvrirParametresRecue;
import JeuDeDame_client.commandes.quitter.Quitter;
import JeuDeDame_client.commandes.quitter.QuitterRecue;
import JeuDeDame_client.commandes.retour_accueil.RetourAccueil;
import JeuDeDame_client.commandes.retour_accueil.RetourAccueilRecue;
import JeuDeDame_client.controleurs.ControleurAccueil;
import JeuDeDame.afficheurs.AfficheurParametresFX;
import JeuDeDame.afficheurs.AfficheurPartieLocaleFX;
import JeuDeDame.vues.VuePartieLocaleFX;
import JeuDeDame.vues.VueAccueilFX;
import JeuDeDame.vues.VueParametresFX;

import static JeuDeDame.Constantes.*;

public class ControleurAccueilFX extends ControleurAccueil<VueAccueilFX> {
	
	
 
	
	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
	}

	
 

	@Override
	protected void demarrer() {
		J.appel(this);
	}
}
