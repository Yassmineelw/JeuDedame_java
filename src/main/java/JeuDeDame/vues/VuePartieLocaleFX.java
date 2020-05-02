package JeuDeDame.vues;

import java.net.URL; 

import java.util.Random;
import java.util.ResourceBundle;

import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import JeuDeDame_client.commandes.retour_accueil.RetourAccueil;
import JeuDeDame_client.commandes.retour_accueil.RetourAccueilPourEnvoi;
import JeuDeDame_client.vues.VuePartieLocale;
import javafx.fxml.Initializable;

import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class VuePartieLocaleFX implements VuePartieLocale, Initializable { 

	@FXML
    private Button RetourMenu;
	
	@FXML
    private RetourAccueilPourEnvoi RetourAcceuil;
    
	@FXML
	private Circle Cercle1;

	@FXML
	private Circle Cercle2;

	@FXML
	private Circle Cercle3;

	@FXML
	private Circle Cercle4;

	@FXML
	private Circle Cercle5;

	@FXML
	private Circle Cercle6;

	@FXML
	private Circle Cercle7;

	@FXML
	private Circle Cercle8;

	@FXML
	private Circle Cercle9;

	@FXML
	private Label XUn;

	@FXML
	private Label XDeux;

	@FXML
	private Label XTrois;

	@FXML
	private Label XQuatre;

	@FXML
	private Label XCunq;

	@FXML
	private Label XSix;

	@FXML
	private Label XSept;

	@FXML
	private Label XHuit;

	@FXML
	private Label XNeuf;

	@FXML
	private Label MessageBas;


	@Override
    public void initialize(URL location, ResourceBundle resources) {
        J.appel(this);

     }
	
	

    @Override
    public void obtenirCommandesPourEnvoi() {
        J.appel(this);

        RetourAcceuil = FabriqueCommande.obtenirCommandePourEnvoi(RetourAccueil.class);
    }

    @Override
    public void installerCapteursEvenementsUsager() {
        J.appel(this);

        RetourMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                J.appel(this);

                RetourAcceuil.envoyerCommande();
            }
        });
    }

    @Override
    public void verifierCommandesPossibles() {
        J.appel(this);
    }
	
	
	
	private int[] filledSquares = new int[9];
	private int[] filledCircles = new int[5];
	private int[] filledX = new int[5];

	private int filledSquaresCounter = 0;
	private int filledCirclesCounter = 0;
	private int filledXCounter = 0;

	private char EquipeGagnante;

	final private int[][] PositionGagnante = { { 1, 5, 9 }, { 3, 5, 7 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 },
			{ 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } };

	private boolean allowMoves = true;

	private boolean tie = false;

	@FXML
	public void handleSquareOneClick(MouseEvent event) {
		this.handleSquareClick(1);
	}

	@FXML
	public void handleSquareTwoClick(MouseEvent event) {
		this.handleSquareClick(2);
	}

	@FXML
	public void handleSquareThreeClick(MouseEvent event) {
		this.handleSquareClick(3);
	}

	@FXML
	public void handleSquareFourClick(MouseEvent event) {
		this.handleSquareClick(4);
	}

	@FXML
	public void handleSquareFiveClick(MouseEvent event) {
		this.handleSquareClick(5);
	}

	@FXML
	public void handleSquareSixClick(MouseEvent event) {
		this.handleSquareClick(6);
	}

	@FXML
	public void handleSquareSevenClick(MouseEvent event) {
		this.handleSquareClick(7);
	}

	@FXML
	public void handleSquareEightClick(MouseEvent event) {
		this.handleSquareClick(8);
	}

	@FXML
	public void handleSquareNineClick(MouseEvent event) {
		this.handleSquareClick(9);
	}

	public void handleSquareClick(int squareNumber) {
		if (!isAlreadySelectedBox(squareNumber) && this.allowMoves == true) {
			switch (squareNumber) {
			case 1:
				this.showCircleOne();
				break;
			case 2:
				this.showCircleTwo();
				break;
			case 3:
				this.showCircleThree();
				break;
			case 4:
				this.showCircleFour();
				break;
			case 5:
				this.showCircleFive();
				break;
			case 6:
				this.showCircleSix();
				break;
			case 7:
				this.showCircleSeven();
				break;
			case 8:
				this.showCircleEight();
				break;
			case 9:
				this.showCircleNine();
				break;
			default:
				System.out.println("Choix Impossible");
				break;
			}

			this.filledSquares[this.filledSquaresCounter] = squareNumber;
			this.filledCircles[this.filledCirclesCounter] = squareNumber;
			this.filledSquaresCounter++;
			this.filledCirclesCounter++;

			if (this.checkVictory()) {
				this.endGame();
			} else {
				this.playRandomMove();

				if (this.checkVictory()) {
					this.endGame();
				}
			}
		} else if (this.filledSquaresCounter >= 9) {
			this.tie = true;
			this.endGame();
		}
	}

	public boolean isAlreadySelectedBox(int squareNumber) {
		boolean found = false;

		for (int filledSquare : this.filledSquares) {
			if (squareNumber == filledSquare) {
				found = true;
			}
		}

		return found == true;
	}

	public boolean checkVictory() {
		if (this.filledCirclesCounter < 3 && this.filledXCounter < 3) {
			return false;
		}

		for (int[] filled : this.PositionGagnante) {
			int slotCounter = 0;

			for (int singleFilled : filled) {
				if (this.isOccupiedByCircle(singleFilled)) {
					slotCounter++;
				}
			}

			if (slotCounter == 3) {
				this.EquipeGagnante = 'O';
				this.allowMoves = false;
				return true;
			}

			slotCounter = 0;

			for (int singleFilled : filled) {
				if (this.isOccupiedByX(singleFilled)) {
					slotCounter++;
				}
			}

			if (slotCounter == 3) {
				this.EquipeGagnante = 'X';
				this.allowMoves = false;
				return true;
			}
		}

		return false;
	}

	public void showCircleOne() {
		this.Cercle1.setVisible(true);
	}

	public void showCircleTwo() {
		this.Cercle2.setVisible(true);
	}

	public void showCircleThree() {
		this.Cercle3.setVisible(true);
	}

	public void showCircleFour() {
		this.Cercle4.setVisible(true);
	}

	public void showCircleFive() {
		this.Cercle5.setVisible(true);
	}

	public void showCircleSix() {
		this.Cercle6.setVisible(true);
	}

	public void showCircleSeven() {
		this.Cercle7.setVisible(true);
	}

	public void showCircleEight() {
		this.Cercle8.setVisible(true);
	}

	public void showCircleNine() {
		this.Cercle9.setVisible(true);
	}

	public void playRandomMove() {
		Random random = new Random();
		int result = random.nextInt(9 - 1 + 1) + 1;
		;

		if (this.filledSquaresCounter < 9) {
			while (this.isAlreadySelectedBox(result)) {
				result = random.nextInt(9 - 1 + 1) + 1;
			}

			switch (result) {
			case 1:
				this.showXOne();
				break;
			case 2:
				this.showXTwo();
				break;
			case 3:
				this.showXThree();
				break;
			case 4:
				this.showXFour();
				break;
			case 5:
				this.showXFive();
				break;
			case 6:
				this.showXSix();
				break;
			case 7:
				this.showXSeven();
				break;
			case 8:
				this.showXEight();
				break;
			case 9:
				this.showXNine();
				break;
			default:
				System.out.println("Choix impossible");
				break;
			}

			this.filledSquares[this.filledSquaresCounter] = result;
			this.filledX[this.filledXCounter] = result;
			this.filledSquaresCounter++;
			this.filledXCounter++;
		} else {
			this.tie = true;
			this.endGame();
		}

	}

	public void showXOne() {
		this.XUn.setVisible(true);
	}

	public void showXTwo() {
		this.XDeux.setVisible(true);
	}

	public void showXThree() {
		this.XTrois.setVisible(true);
	}

	public void showXFour() {
		this.XQuatre.setVisible(true);
	}

	public void showXFive() {
		this.XCunq.setVisible(true);
	}

	public void showXSix() {
		this.XSix.setVisible(true);
	}

	public void showXSeven() {
		this.XSept.setVisible(true);
	}

	public void showXEight() {
		this.XHuit.setVisible(true);
	}

	public void showXNine() {
		this.XNeuf.setVisible(true);
	}

	public boolean isOccupiedByCircle(int circlePosition) {
		boolean found = false;

		for (int filledCircle : this.filledCircles) {
			if (filledCircle == circlePosition) {
				found = true;
			}
		}

		return found == true;
	}

	public boolean isOccupiedByX(int xPosition) {
		boolean found = false;

		for (int filled : this.filledX) {
			if (filled == xPosition) {
				found = true;
			}
		}

		return found == true;
	}

	public void endGame() {
		this.allowMoves = false;

		if (this.tie == true) {
			this.MessageBas.setText("Aucun gagnant, Meilleure chance la prochaine fois");
		} else if (String.valueOf(this.EquipeGagnante).equals("O")) {
			this.MessageBas.setText("Vous avez gagner!");
		} else if (String.valueOf(this.EquipeGagnante).equals("X")) {
			this.MessageBas.setText("Désolé, vous avez perdue!");
		}
	}

	@FXML
	public void handleResetButton(ActionEvent event) {
		this.Cercle1.setVisible(false);
		this.Cercle2.setVisible(false);
		this.Cercle3.setVisible(false);
		this.Cercle4.setVisible(false);
		this.Cercle5.setVisible(false);
		this.Cercle6.setVisible(false);
		this.Cercle7.setVisible(false);
		this.Cercle8.setVisible(false);
		this.Cercle9.setVisible(false);

		this.XUn.setVisible(false);
		this.XDeux.setVisible(false);
		this.XTrois.setVisible(false);
		this.XQuatre.setVisible(false);
		this.XCunq.setVisible(false);
		this.XSix.setVisible(false);
		this.XSept.setVisible(false);
		this.XHuit.setVisible(false);
		this.XNeuf.setVisible(false);

		this.EquipeGagnante = 0;

		this.allowMoves = true;
		this.tie = false;

		this.MessageBas.setText("");

		this.filledSquares = new int[9];
		this.filledCircles = new int[5];
		this.filledX = new int[5];

		this.filledSquaresCounter = 0;
		this.filledCirclesCounter = 0;
		this.filledXCounter = 0;
	}


}
