package live_package;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainApp extends Application
{
	boolean stop = false;
	boolean run = false;
	
	static int meineZahl;
	public int speed = 1;
	private int buttonBreite = 60;
	
	public void setMeineZahl(int neueZahl)
	{
		MainApp.meineZahl = neueZahl;
	}
	
	public static int getMeineZahl()
	{
		return meineZahl;
	}
	
	@Override
	public void start(Stage FirstStage) throws InterruptedException
	{
		VBox WindowBox = new VBox();
		Scene MyScene = new Scene(WindowBox, 700, 400);
		Button StartButton = new Button();
		Button RestartButton = new Button();
		Button StopButton = new Button();
		LimitedTextField InputField = new LimitedTextField();
		Label WinLabel = new Label();
		Label RandomLabel = new Label();
		Label StopLabel = new Label();
		
		StartButton.setTranslateX(8);
		StartButton.setTranslateY(130);
		StartButton.setMaxWidth(buttonBreite);
		
		RestartButton.setTranslateX(76*2-8);
		RestartButton.setTranslateY(97);
		RestartButton.setMaxWidth(buttonBreite);
		
		StopButton.setTranslateX(76);
		StopButton.setTranslateY(64);
		StopButton.setMaxWidth(buttonBreite);
		
		WinLabel.setTranslateY(-56);
		
		WindowBox.setSpacing(8);
		WindowBox.setPadding(new Insets(10));
		FirstStage.setScene(MyScene);
		FirstStage.setTitle("Suchmaschine");
		StartButton.setText("Start");
		RestartButton.setText("Restart");
		StopButton.setText("Stop");
		
		WindowBox.getChildren().addAll
		(	
			StartButton, 
			RestartButton, 
			StopButton, 
			InputField, 
			WinLabel, 
			StopLabel, 
			RandomLabel
		);
		
		FirstStage.show();
		
		RandomLabel.textProperty().addListener(new ChangeListener<String>()
		{
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
			{
				if(InputField.getText().equals(RandomLabel.getText()))
				{
					WinLabel.setText("ERFOLG");
				}
			}
		});
		
		Timeline tl = new Timeline(new KeyFrame(
				Duration.millis(speed),
				ae ->
				{
					Platform.runLater(() ->
					{
						if(!RandomLabel.getText().equals(InputField.getText()))
						{
							meineZahl = InputField.getLength();
							RandomLabel.setText(RandomGen.RandomTextausgabe());
						}
					});
				}));
		tl.setCycleCount(Animation.INDEFINITE);
		
		StartButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				tl.play();
				InputField.setEditable(false);
				
				if(stop == false)
				{
					run = true;
				}
			}
		});
		
		RestartButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				if(stop == true)
				{
					InputField.setEditable(true);
					RandomLabel.setText("");
					StopLabel.setText("");
					WinLabel.setText("");
					
					stop = false;
				}
			}
		});
		
		StopButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				tl.stop();
				StopLabel.setText("Angehalten. Bitte 'Restart' drücken");
				
				stop = true;
				run = false;
			}
		});
	}
	
	public static void main(String[] args)
	{
		launch();
	}
}
