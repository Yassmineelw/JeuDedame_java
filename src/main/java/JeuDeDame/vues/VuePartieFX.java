package JeuDeDame.vues;


import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.J;
import javafx.fxml.Initializable;
import JeuDeDame_client.vues.VuePartie;


public abstract class VuePartieFX implements VuePartie, Initializable {
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	    J.appel(this);

	} 

	@Override
	public void obtenirCommandesPourEnvoi() {
	    J.appel(this);

	}

	@Override
	public void installerCapteursEvenementsUsager() {
	    J.appel(this);

	}

	@Override
	public void verifierCommandesPossibles() {
	    J.appel(this);

	}

}
