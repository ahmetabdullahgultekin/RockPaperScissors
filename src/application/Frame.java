package application;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Frame implements Initializable {

	@FXML
	private ImageView iwRock;
	@FXML
	private ImageView iwPaper;
	@FXML
	private ImageView iwScissors;
	@FXML
	private ImageView iwHuman;
	@FXML
	private ImageView iwComputer;
	@FXML
	private Label labelQuestion;
	@FXML
	private Button btRestart;
	@FXML
	private Label labelScore;

	Image imageRock;
	Image imagePaper;
	Image imageScissors;
	Image imageVictory;
	Image imageDefeat;
	Random random;
	Animation animationBt;
	int cmp;
	int scoreH;
	int scoreC;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		imageRock = new Image("/Resources/Rock.png");
		imagePaper = new Image("/Resources/Paper.png");
		imageScissors = new Image("/Resources/Scissors.png");

		iwRock.setImage(imageRock);
		iwPaper.setImage(imagePaper);
		iwScissors.setImage(imageScissors);
		imageVictory = new Image("Resources/victory.png");
		imageDefeat = new Image("Resources/defeat.png");

		scoreH = 0;
		scoreC = 0;

		random = new Random();
		/*
		Computer
		1 Paper
		2 Rock
		3 Scissors
		 */

		addAction();
	}

	public void addAction() {

		iwPaper.setOnMouseClicked(e -> select("paper"));
		iwRock.setOnMouseClicked(e -> select("rock"));
		iwScissors.setOnMouseClicked(e -> select("scissors"));
		btRestart.setOnMouseClicked(e -> restartGame());
	}

	public void restartGame() {

		animationBt.stop();
		scoreH = 0;
		scoreC = 0;
		labelScore.setText("You: 0 Computer: 0");
		labelQuestion.setText("What is your choice?");
		iwComputer.setImage(null);
		iwHuman.setImage(null);
		setdisable(false);
	}

	public void select(String choice) {

		animationBt = new Transition() {

			{
				setCycleCount(Animation.INDEFINITE);
				setCycleDuration(Duration.millis(2000));
				setInterpolator(Interpolator.EASE_OUT);
			}

			@Override
			protected void interpolate(double frac) {
				Color vColor = new Color(0.5, 0.7, 0.2, 1 - frac);
				btRestart.setBackground(new Background(new BackgroundFill(vColor, new CornerRadii(15), Insets.EMPTY)));
			}
		};

		cmp = random.nextInt(3) + 1;
		switch (cmp) {
			case 1:
				iwComputer.setImage(imagePaper);
				break;
			case 2:
				iwComputer.setImage(imageRock);
				break;
			case 3:
				iwComputer.setImage(imageScissors);
				break;

			default:
				System.out.println("Error!");
				break;
		}


		switch (choice) {

			case "paper":
				iwHuman.setImage(imagePaper);

				switch (cmp) {
					case 1:
						scoreH += 0;
						scoreC += 0;
						break;
					case 2:
						scoreH += 1;
						scoreC += 0;
						break;
					case 3:
						scoreH += 0;
						scoreC += 1;
						break;

					default:
						System.out.println("Error!");
						break;
				}
				break;

			case "rock":
				iwHuman.setImage(imageRock);

				switch (cmp) {
					case 1:
						scoreC += 1;
						break;
					case 2:
						break;
					case 3:
						scoreH += 1;
						break;

					default:
						System.out.println("Error!");
						break;
				}
				break;

			case "scissors":
				iwHuman.setImage(imageScissors);

				switch (cmp) {
					case 1:
						scoreH += 1;
						break;
					case 2:
						scoreC += 1;
						break;
					case 3:
						break;

					default:
						System.out.println("Error!");
						break;
				}
				break;

			default:
				System.out.println("Error!");
				break;
		}

		labelScore.setText("You: " + scoreH + " Computer: " + scoreC);

		if(scoreC == 3 || scoreH == 3 ) {

			boolean who = false;

			if(scoreC == 3) {
				labelQuestion.setText("You lose!");
				who = false;
			}
			if(scoreH == 3 ) {
				labelQuestion.setText("You won!");
				who = true;
			}

			setdisable(true);
			animationBt.play();


			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Game Over!");
			alert.setContentText((who) ? "You won!" : "Computer won!");
			alert.setHeaderText((who) ? "Congrulations!" : "Noob!");
			alert.setGraphic((who) ? new ImageView(imageVictory) : new ImageView(imageDefeat));
			alert.show();
		}
	}

	public void setdisable(boolean is) {

		iwPaper.setDisable(is);
		iwRock.setDisable(is);
		iwScissors.setDisable(is);
	}
}
