package JeuDeDame.vues;

import java.io.File; 
import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun.systeme.Systeme;
import commun_client.commandes.FabriqueCommande;
import commun_javafx.ChargeurDeVue;
import commun_javafx.DialogueModal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import JeuDeDame.vues.VueSauvegardesFX;
import sauvegarder_partie.SauvegarderPartie;
import sauvegarder_partie.SauvegarderPartiePourEnvoi;
import JeuDeDame.vues.VuePartieLocaleFX;
import JeuDeDame_client.commandes.nouvelle_partie.NouvellePartie;
import JeuDeDame_client.commandes.nouvelle_partie.NouvellePartiePourEnvoi;
import JeuDeDame_client.commandes.ouvrir_parametres.OuvrirParametres;
import JeuDeDame_client.commandes.ouvrir_parametres.OuvrirParametresPourEnvoi;
import JeuDeDame_client.commandes.quitter.Quitter;
import JeuDeDame_client.commandes.quitter.QuitterPourEnvoi;
import JeuDeDame_client.vues.VueAccueil;
import static JeuDeDame.Constantes.*;
import static JeuDeDame.Constantes.CHEMIN_CHAINES;
import static JeuDeDame.Constantes.CHEMIN_PARTIE_LOCALE_CSS;
import static JeuDeDame.Constantes.CHEMIN_PARTIE_LOCALE_FXML;

import static JeuDeDame.Constantes.CHEMIN_VUE_SAUVEGARDES_CSS;
import static JeuDeDame.Constantes.CHEMIN_VUE_SAUVEGARDES_FXML;

public class VueAccueilFX implements VueAccueil, Initializable {
	
	@FXML
	Button boutonNouvellePartie, menuSauvegarderPartieLocale, boutonOuvrirParametres;
	SauvegarderPartiePourEnvoi sauvegarderPartiePourEnvoi;
	OuvrirParametresPourEnvoi ouvrirParametresPourEnvoi;
	NouvellePartiePourEnvoi nouvellePartiePourEnvoi;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		 
		DoitEtre.nonNul(menuSauvegarderPartieLocale);

		DoitEtre.nonNul(boutonNouvellePartie);
		DoitEtre.nonNul(boutonOuvrirParametres);
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		sauvegarderPartiePourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(SauvegarderPartie.class);

		ouvrirParametresPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(OuvrirParametres.class);
		nouvellePartiePourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(NouvellePartie.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
		boutonOuvrirParametres.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				ouvrirParametresPourEnvoi.envoyerCommande();
			}
		});
		
		boutonNouvellePartie.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				nouvellePartiePourEnvoi.envoyerCommande();
			}
		});
		
		menuSauvegarderPartieLocale.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				File fichierChoisi = DialogueModal.ouvrirDialogueFichiers();

				if(fichierChoisi != null) {

					String cheminDansHome = Systeme.cheminDansHome(fichierChoisi);

					sauvegarderPartiePourEnvoi.setCheminDansHome(cheminDansHome);
					sauvegarderPartiePourEnvoi.envoyerCommande();
				}
			}
		});
	}
	public VueSauvegardesFX creerVueSauvegardes() {
		J.appel(this);

		ChargeurDeVue<VueSauvegardesFX> chargeur = new ChargeurDeVue<VueSauvegardesFX>(CHEMIN_VUE_SAUVEGARDES_FXML,
						CHEMIN_CHAINES,
						CHEMIN_VUE_SAUVEGARDES_CSS);
		
		VueSauvegardesFX vueSauvegardes = chargeur.getVue();
		 
		
		return vueSauvegardes;

	}

	public VuePartieLocaleFX creerVuePartieLocale() {
		J.appel(this);

		ChargeurDeVue<VuePartieLocaleFX> chargeur = new ChargeurDeVue<VuePartieLocaleFX>(CHEMIN_PARTIE_LOCALE_FXML,
						CHEMIN_CHAINES,
						CHEMIN_PARTIE_LOCALE_CSS);
		
		VuePartieLocaleFX vuePartieLocale = chargeur.getVue();
		
		Parent parent = chargeur.getParent();
		
		 
		
		return vuePartieLocale;
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);

	}
}
