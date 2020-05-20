package JeuDeDame.controleurs;

import commun.debogage.J;
import commun_javafx.DialogueModal;
import javafx.scene.Scene;
import javafx.stage.Stage;
import JeuDeDame_client.controleurs.ControleurAccueil;
import JeuDeDame.vues.VueAccueilFX;

public class ControleurAccueilFX extends ControleurAccueil<VueAccueilFX> {
	
	
	private Scene sceneParametres;
	private Stage dialogueParametres;
	
	
	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
	}

	
	
	
	private void ouvrirParametres() {
		J.appel(this);

		dialogueParametres = DialogueModal.ouvrirDialogueModal(sceneParametres);
	}

	private void fermerParametres() {
		J.appel(this);
		
		if(dialogueParametres != null) {
			
			dialogueParametres.close();
		}
	}

	@Override
	protected void demarrer() {
		J.appel(this);
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
