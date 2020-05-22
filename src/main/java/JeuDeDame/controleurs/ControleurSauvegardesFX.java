package JeuDeDame.controleurs;

import java.io.File;    
import java.io.IOException;

import commun.debogage.J;
import commun.systeme.Systeme;
import commun.utiles.Json;
import javafx.application.Platform;
import JeuDeDame.modeles.partie_locale.PartieLocale;
import JeuDeDame_client.controleurs.ControleurSauvegardes;
import JeuDeDame.afficheurs.AfficheurSauvegardesFX;
import JeuDeDame.vues.VueSauvegardesFX;

public class ControleurSauvegardesFX extends ControleurSauvegardes<VueSauvegardesFX, AfficheurSauvegardesFX>{
	
	@Override
	protected void demarrer(){
		super.demarrer();
		J.appel(this);
		 
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				chercherSauvegardes();
			}
		});
		
		
	}

	private void chercherSauvegardes() {
		J.appel(this);
		
		File home = Systeme.getHome().toFile();
		
		chercherSauvegardes(home);
		
		vue.cacherRechercheEnCours();
	}
	
	
	private void chercherSauvegardes(File repertoire) {
		J.appel(this);
		
		// XXX: en Windows, listFiles() peut retourner null
		if(repertoire.listFiles() == null) return;
		
		for(File fichier : repertoire.listFiles()) {

			if(fichier.isFile() && fichier.getName().endsWith("json")) {
				
				ajouterSauvegardeSiPossible(fichier);
				
			} else if(fichier.isDirectory() && !fichier.getName().startsWith(".")) {
				
				Platform.runLater(new Runnable() {
					
					@Override
					public void run() {
						chercherSauvegardes(fichier);
					}
				});
			}
		}
	}

	private void ajouterSauvegardeSiPossible(File fichier) {
		J.appel(this);

		PartieLocale sauvegardePartie = null;

		try {

			sauvegardePartie = Json.aPartirFichier(fichier, PartieLocale.class);

		}catch(IOException e) { }

		if(sauvegardePartie != null ) {

			ajouterSauvegarde(fichier);
		}
	}

	private void ajouterSauvegarde(File fichier) {
		J.appel(this);

		modele.ajouterSauvegarde(Systeme.cheminDansHome(fichier));
		afficheur.rafraichirAffichage(modele, vue);
	}
	

}
