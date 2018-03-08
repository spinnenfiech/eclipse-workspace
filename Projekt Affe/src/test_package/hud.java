package test_package;

import javafx.event.ActionEvent;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class hud extends Application //Meine Hauptausführung mit der Main
{
	static int meineZahl;
	
	public int speed = 1;
	
	boolean restart = false;
	boolean run = false;
	boolean stop = false;
	boolean pseudoThreadKontrolle = false;

	public void setMeineZahl(int neueZahl)
	{
		hud.meineZahl = neueZahl;
	}

	public static int getMeineZahl()
	{
		return meineZahl;
	}
	
	@Override
	public void start(Stage firstStage) throws InterruptedException
	{
		System.out.println("jetzt wird 'affe' gestartet");
		VBox windowVBox = new VBox();
		Scene firstScene = new Scene(windowVBox, 700, 400);
		Button startButton = new Button();
		Button restartButton = new Button();
		Button stopButton = new Button();
		TextField_Begrenzer inputField = new TextField_Begrenzer();
		Label winLabel = new Label();
		Label percentageLabel = new Label();
		Label timeLabel = new Label();
		Label label = new Label();
		Label stopLabel = new Label();
		ProgressIndicator pi = new ProgressIndicator(0.5);
		ProgressBar	pb = new ProgressBar(0.0);
		
		windowVBox.setSpacing(8);
		windowVBox.setPadding(new Insets(10));
		firstStage.setScene(firstScene);
		firstStage.setTitle("Suchmaschine");
		firstStage.show();
		startButton.setText("Start");
		restartButton.setText("Nochmal");
		stopButton.setText("Stop");
		percentageLabel.setText("*percentageLabel*");
		timeLabel.setText("*timeLabel*");
		winLabel.setText("win");
		windowVBox.getChildren().add(startButton);
		windowVBox.getChildren().add(restartButton);
		windowVBox.getChildren().add(stopButton);
		windowVBox.getChildren().add(inputField);
		windowVBox.getChildren().add(winLabel);
		windowVBox.getChildren().add(percentageLabel);
		windowVBox.getChildren().add(timeLabel);
		windowVBox.getChildren().add(label);
		windowVBox.getChildren().add(stopLabel);
		windowVBox.getChildren().add(pb);
		windowVBox.getChildren().add(pi);
		
		label.textProperty().addListener(new ChangeListener<String>()
		{
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
			{
				if(inputField.getText().equals(label.getText()))
				{
					winLabel.setText("ERFOLG");
					System.out.println("ERFOLG");
					Platform.runLater(() -> pb.setProgress(1));
				}
			}
		});
		
		Timeline tl = new Timeline(new KeyFrame(
				Duration.millis(speed),
				ae ->
				{
					Platform.runLater(() ->
					{
						if(!winLabel.getText().equals("ERFOLG"))
						{
							System.out.println("Service läuft...");
							System.out.println("Having: " + label.getText() + 
									" | Looking for: " + inputField.getText() + 
									" | inputField length: " + inputField.getLength() + 
									" | meineZahl length: " + meineZahl + 
									" | getMeineZahl length: " + getMeineZahl());

							meineZahl = inputField.getLength();
							label.setText(das_affenprojekt_experimentieren.RandomTextausgabe());
						}
					});
				}));
		tl.setCycleCount(Animation.INDEFINITE);
		
		
		
		startButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
		 		tl.play();
				inputField.setEditable(false);
				System.out.println("start button pressed");
				//service.restart();
				
				if(stop == false)
				{
					System.out.println("Start-if aktiv");
					pseudoThreadKontrolle = false;
					run = true;
					pb.setProgress(ProgressBar.INDETERMINATE_PROGRESS);
				}
			}
		});
		
		stopButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				pb.setProgress(0);
				stopLabel.setText("Angehalten. Bitte 'Nochmal' drücken");
				tl.stop();
				restart = false;
				stop = true;
				run = false;
			}
		});
		
		restartButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				if(stop == true)
				{
					inputField.setEditable(true);
					label.setText("");
					stopLabel.setText("");
					winLabel.setText("");
					inputField.setEditable(true);
					//service.cancel();
					
					restart = true;
					stop = false;
				}
			}
		});
	}

	public static void main(String[] args)
	{
		launch();
	}
}
