package application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Parent pane = FXMLLoader.load(getClass().getResource("Frame.fxml"));
			primaryStage.setScene(new Scene(pane));
			primaryStage.setOnCloseRequest(e -> {
				Platform.exit();
				System.exit(0);
			});
			primaryStage.setTitle("RockPaperScissors");
			primaryStage.getIcons().add(new Image("/Resources/Rock.png"));
			primaryStage.centerOnScreen();
			primaryStage.setResizable(false);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
