package JeuDeDame_client.controleurs;

import commun_client.mvc.controleurs.ControleurModeleVue;
import JeuDeDame.modeles.partie.Partie;
import JeuDeDame.modeles.partie.PartieLectureSeule;
import JeuDeDame_client.afficheurs.AfficheurPartie;

import JeuDeDame_client.vues.VuePartie;
import commun.debogage.J;

public abstract class ControleurPartie<PLS extends PartieLectureSeule, P extends Partie<PLS>, V extends VuePartie, A extends AfficheurPartie<PLS, V>>

		extends ControleurModeleVue<PLS, P, V, A> {
	@Override
	protected void demarrer() {
		J.appel(this);

	}

	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);

	}

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);

	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);

	}

}
