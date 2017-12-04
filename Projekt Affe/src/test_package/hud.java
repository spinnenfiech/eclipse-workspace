package test_package;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class hud extends Application
{
	@Override
	public void start(Stage firstStage)
	{
		VBox windowVBox = new VBox();
		Scene firstScene = new Scene(windowVBox, 500, 250);
		Button startButton = new Button();
		Button restartButton = new Button();
		TextField inputField = new TextField();
		Label winLabel = new Label();
		Label percentageLabel = new Label();
		Label randomStringLabel = new Label();
		Label timeLabel = new Label();
		
		firstStage.setScene(firstScene);
		firstStage.setTitle("Suchmaschine");
		firstStage.show();
		startButton.setText("Start");
		restartButton.setText("Nochmal");
		winLabel.setText("ERFOLG");
		percentageLabel.setText("*noch nicht erledigt*");
		randomStringLabel.setText("*noch nicht erledigt*");
		timeLabel.setText("*noch nicht erledigt*");
		windowVBox.getChildren().add(startButton);
	}
	public static void main(String[] args)
	{
		launch();
	}
}
