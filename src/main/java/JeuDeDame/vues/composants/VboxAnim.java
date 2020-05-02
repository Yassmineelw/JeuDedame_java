package JeuDeDame.vues.composants;
 
 

import commun.debogage.J;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.util.Duration;
 
import javafx.scene.layout.VBox;

public class VboxAnim extends VBox {

	private Timeline animationSurvol = new Timeline();

	public VboxAnim() {
		super();
		J.appel(this);

		creerAnimation();

		animationSurvol.setCycleCount(-1);
		installerListeners();
	}

	private void installerListeners() {
		J.appel(this);

		this.setOnMouseEntered(new EventHandler<Event>() {

			public void handle(Event event) {
				J.appel(this);

				animationSurvol.playFromStart();
			}
		});

		this.setOnMouseExited(new EventHandler<Event>() {

			public void handle(Event event) {
				J.appel(this);

				animationSurvol.stop();
				 
				VboxAnim.this.setOpacity(1);
			}
		});

	}

	private void creerAnimation() {
		J.appel(this);

		double delaiMilisecondes = 700;
		double opaciteNormale = 1;
		double opaciteBasse = 0.6;

		animationSurvol.getKeyFrames()
				.add(new KeyFrame(Duration.ZERO, new KeyValue(opacityProperty(), opaciteNormale)));

		animationSurvol.getKeyFrames()
				.add(new KeyFrame(new Duration(delaiMilisecondes), new KeyValue(opacityProperty(), opaciteBasse)));

		animationSurvol.getKeyFrames().add(
				new KeyFrame(new Duration(delaiMilisecondes * 1), new KeyValue(opacityProperty(), opaciteNormale)));
	}

}
