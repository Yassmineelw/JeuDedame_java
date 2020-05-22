package JeuDeDame.controleurs;

import commun.debogage.Erreur; 
import commun.debogage.J;
import commun.systeme.Systeme;
import commun.utiles.Json;
import commun_client.mvc.controleurs.FabriqueControleur;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import commun_javafx.DialogueModal;
import javafx.scene.Scene;
import javafx.stage.Stage;
import JeuDeDame.modeles.partie_locale.PartieLocale;
import sauvegarder_partie.SauvegarderPartie;
import ouvrir_sauvegarde.OuvrirSauvegarde;
import ouvrir_sauvegarde.OuvrirSauvegardeRecue;
import JeuDeDame.modeles.sauvegardes.Sauvegardes;
import JeuDeDame.afficheurs.AfficheurSauvegardesFX;
import JeuDeDame.controleurs.ControleurSauvegardesFX;
import JeuDeDame.vues.VueSauvegardesFX;
import sauvegarder_partie.SauvegarderPartieRecue;
import JeuDeDame.afficheurs.AfficheurPartieLocaleFX;
import JeuDeDame.controleurs.ControleurPartieLocaleFX;
import JeuDeDame.vues.VuePartieLocaleFX;
import JeuDeDame_client.controleurs.ControleurAccueil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import JeuDeDame.vues.VueAccueilFX;

public class ControleurAccueilFX extends ControleurAccueil<VueAccueilFX> {
	
	
 
	private PartieLocale partieLocale;
	
	@Override
	
	protected void demarrer() {
		J.appel(this);
		
		afficherSauvegardes();
	}


	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);

	 
		
		installerRecepteurCommande(SauvegarderPartie.class, new RecepteurCommandeMVC<SauvegarderPartieRecue>() {
			@Override
			public void executerCommandeMVC(SauvegarderPartieRecue commande) {
				J.appel(this);
				
				sauvegarderPartieLocale(commande.getCheminDansHome());
			}

		});

	 
 
		installerRecepteurCommande(OuvrirSauvegarde.class, new RecepteurCommandeMVC<OuvrirSauvegardeRecue>() {
			@Override
			public void executerCommandeMVC(OuvrirSauvegardeRecue commande) {
				J.appel(this);
				
				ouvrirSauvegarde(commande.getCheminDansHome());
				
			}
		});
	}
 


	private void instancierMVCPartieLocale() {
		J.appel(this);

		VuePartieLocaleFX vuePartieLocale = vue.creerVuePartieLocale();
		
		AfficheurPartieLocaleFX afficheur = new AfficheurPartieLocaleFX();
		
		FabriqueControleur.creerControleur(ControleurPartieLocaleFX.class, partieLocale, vuePartieLocale, afficheur);
	}
	
	private void ouvrirSauvegarde(String cheminDansHome) {
		J.appel(this);
		
		File sauvegarde = Systeme.aPartirCheminDansHome(cheminDansHome);
		
		try {

			partieLocale = Json.aPartirFichier(sauvegarde, PartieLocale.class);

		} catch (IOException e) {
			
			Erreur.fatale(String.format("La sauvegarde '%s' doit être valide", cheminDansHome), e);

		}
		
		instancierMVCPartieLocale();
	}

	private void afficherSauvegardes() {
		J.appel(this);
		
		VueSauvegardesFX vueSauvegardes = vue.creerVueSauvegardes();
		
		Sauvegardes lesSauvegardes = new Sauvegardes();
		
		AfficheurSauvegardesFX afficheur = new AfficheurSauvegardesFX();
		
 	}

	private void sauvegarderPartieLocale(String cheminDansHome) {
		J.appel(this);

		if(partieLocale != null) {
			
			File fichierDansHome = Systeme.aPartirCheminDansHome(cheminDansHome);
			
			try {

				Json.sauvegarder(fichierDansHome, partieLocale);

			} catch (IOException e) {
				
				Erreur.nonFatale(String.format("Impossible d'écrire le fichier %s", fichierDansHome.getPath()), e);

			}
		}
	}


	@Override
	protected void obtenirMessagesPourEnvoi() {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void installerReceptionMessages() {
		// TODO Auto-generated method stub
		
	}
}