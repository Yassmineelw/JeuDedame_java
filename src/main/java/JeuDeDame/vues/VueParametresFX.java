package JeuDeDame.vues;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import JeuDeDame_client.commandes.changer_locale.ChangerLocale;
import JeuDeDame_client.commandes.changer_locale.ChangerLocalePourEnvoi;
import JeuDeDame_client.commandes.retour_accueil.RetourAccueil;
import JeuDeDame_client.commandes.retour_accueil.RetourAccueilPourEnvoi;
import JeuDeDame_client.vues.VueParametres;
import JeuDeDame.vues.composants.CaseAjustable;
import JeuDeDame.vues.composants.VboxAnim;

public class VueParametresFX implements VueParametres, Initializable {

//	@FXML
	// private Text texteTmpParametres;

	@FXML
	private Button boutonChangerLangue;

	@FXML
	private Button boutonRetour;
	@FXML
	private Text texteTmpPartieLocale;
	
	private RetourAccueilPourEnvoi retourAccueil;
	private ChangerLocalePourEnvoi changerLocale;

	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);

		

		// Nouvelle vue?
		//texteTmpParametres.setText(texteTmpParametres.getText() + " (" +
		//System.identityHashCode(this) + ")");
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);

		changerLocale = FabriqueCommande.obtenirCommandePourEnvoi(ChangerLocale.class);

		retourAccueil = FabriqueCommande.obtenirCommandePourEnvoi(RetourAccueil.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);

		boutonRetour.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				retourAccueil.envoyerCommande();
			}
		});

		boutonChangerLangue.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				changerLocale.setLocale(choisirProchaineLangue());
				changerLocale.envoyerCommande();
			}
		}); 
	}

	private Locale choisirProchaineLangue() {
		J.appel(this);

		Locale prochaineLangue = Locale.CANADA_FRENCH;

		if (Locale.getDefault() == Locale.CANADA_FRENCH) {

			prochaineLangue = Locale.CANADA;
		}

		return prochaineLangue;
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
	}

}
