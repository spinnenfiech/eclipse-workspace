package test_package;

import javafx.application.Application;
import javafx.geometry.Insets;
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
		TextField_Begrenzer inputField = new TextField_Begrenzer();
		Label winLabel = new Label();
		Label percentageLabel = new Label();
		Label timeLabel = new Label();
		das_affenprojekt_experimentieren.RandomTextausgabe();
		System.out.println(das_affenprojekt_experimentieren.RandomTextausgabe());
		
		windowVBox.setSpacing(8);
		windowVBox.setPadding(new Insets(10));
		firstStage.setScene(firstScene);
		firstStage.setTitle("Suchmaschine");
		firstStage.show();
		startButton.setText("Start");
		restartButton.setText("Nochmal");
		winLabel.setText("ERFOLG");
		percentageLabel.setText("*percentageLabel*");
		//randomStringLabel.setText("*randomStringLabel*");
		timeLabel.setText("*timeLabel*");
		windowVBox.getChildren().add(startButton);
		windowVBox.getChildren().add(restartButton);
		windowVBox.getChildren().add(inputField);
		windowVBox.getChildren().add(winLabel);
		windowVBox.getChildren().add(percentageLabel);
		//windowVBox.getChildren().add(randomStringLabel);
		windowVBox.getChildren().add(timeLabel);
	}
	public static void main(String[] args)
	{
		launch();
	}
}
