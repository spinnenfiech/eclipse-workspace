package test_package;

import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class hud extends Application
{
	@Override
	public void start(Stage firstStage) throws InterruptedException
	{
		VBox windowVBox = new VBox();
		Scene firstScene = new Scene(windowVBox, 500, 250);
		Button startButton = new Button();
		Button restartButton = new Button();
		TextField_Begrenzer inputField = new TextField_Begrenzer();
		Label winLabel = new Label();
		Label percentageLabel = new Label();
		Label timeLabel = new Label();
		das_affenprojekt_experimentieren label = new das_affenprojekt_experimentieren();
		
		windowVBox.setSpacing(8);
		windowVBox.setPadding(new Insets(10));
		firstStage.setScene(firstScene);
		firstStage.setTitle("Suchmaschine");
		firstStage.show();
		startButton.setText("Start");
		restartButton.setText("Nochmal");
		percentageLabel.setText("*percentageLabel*");
		timeLabel.setText("*timeLabel*");
		windowVBox.getChildren().add(startButton);
		windowVBox.getChildren().add(restartButton);
		windowVBox.getChildren().add(inputField);
		windowVBox.getChildren().add(winLabel);
		windowVBox.getChildren().add(percentageLabel);
		windowVBox.getChildren().add(label);
		windowVBox.getChildren().add(timeLabel);
		
		inputField.textProperty().addListener(new ChangeListener<String>()
		{
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
			{
				if(inputField.getText().equals(label))
				{
					winLabel.setText("ERFOLG");
				}
				else
				{
					winLabel.setText("warte auf ergebnis");
				}
			}
		});
		
		startButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				try
				{
					//int i = 0;
					while(!winLabel.getText().equals("ERFOLG"))
					{
						Thread.sleep(10);
						label.setText(label.RandomTextausgabe());
						//i++;
					}
					Thread.sleep(10);
				}
				catch (InterruptedException e1)
				{
					e1.printStackTrace();
				}
			}
		});
	}
	
	public static void main(String[] args)
	{
		launch();
	}
}
