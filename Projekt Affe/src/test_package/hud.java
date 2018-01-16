package test_package;

import javafx.event.ActionEvent;

import com.sun.javafx.scene.paint.GradientUtils.Point;
import com.sun.xml.internal.ws.wsdl.writer.document.Port;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class hud extends Application //Meine Hauptausführung mit der Main
{
	static int meineZahl;
	
	public int speed = 10;
	
	boolean run = true;
	boolean stop = false;
	
	public void setMeineZahl(int neueZahl)
	{
		hud.meineZahl = neueZahl;
	}

	static int getMeineZahl()
	{
		return meineZahl;
	}
	
	@Override
	public void start(Stage firstStage) throws InterruptedException
	{	
		System.out.println("jetzt wird 'affe' gestartet");
		//das_affenprojekt_experimentieren affe = new das_affenprojekt_experimentieren();
		
		VBox windowVBox = new VBox();
		Scene firstScene = new Scene(windowVBox, 700, 400);
		Button startButton = new Button();
		Button restartButton = new Button();
		Button stopButton = new Button();
		TextField_Begrenzer inputField = new TextField_Begrenzer(); //Limitiert auf nur max. 10 Anschläge und nur a-z
		//inputField.textProperty().addListener((to, from, o) -> 
		Label winLabel = new Label();
		Label percentageLabel = new Label(); //Eine Prozentanzeige, wie viel des gesuchten Wortes schon mal übereinstimmten. Bei 100% hat man quasi gewonnen (in progress)
		Label timeLabel = new Label(); //Eine Zeitanzeige, welche beim Start drücken anfängt und bei 100% aufhört
		Label label = new Label(); //Mein Affe, welcher mir wahllose Buchstaben in dieses Label füllt
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
		
		label.textProperty().addListener(new ChangeListener<String>() //Meine Überprüfung, ob das gesuchte Wort schon im label gefunden worden ist. Funktioniert, wurde aber noch nicht mit dem label ausprobiert
		{
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
			{
				if(inputField.getText().equals(label.getText())) //Die Ausgabe, ob das eingegebene Wort gefunden wurde
				{
					winLabel.setText("ERFOLG");
					System.out.println("ERFOLG");
					Platform.runLater(() -> pb.setProgress(1));
				}
			}
		});
		
		Thread t = new Thread()
		{
			public void run()
			{
				while(!inputField.getText().equals(label) && run == true)
				{
					inputField.setEditable(false);
					
					if(winLabel.getText().equals("ERFOLG"))
					{
						break;
					}
					
					try
					{
						Thread.sleep(speed);
					}
					catch (InterruptedException e1)
					{
						e1.printStackTrace();
					}
					
					Platform.runLater(() ->
					{
						System.out.println("Having: " + label.getText() + 
								" | Looking for: " + inputField.getText() + 
								" | inputField length: " + inputField.getLength() + 
								" | meineZahl length: " + meineZahl + 
								" | getMeineZahl length: " + getMeineZahl());
						
						label.setText(das_affenprojekt_experimentieren.RandomTextausgabe());
						
						meineZahl = inputField.getLength();
						
						if(winLabel.getText().equals("ERFOLG"))
						{
							label.setText(inputField.getText());
						}
					});
				}
			}
		};
		
		startButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{	
				while(stop == false)
				{
					while(run == true)
					{
						t.start();
						break;
					}
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
				
				t.interrupt();
				
				stop = true;
				run = false;
			}
		});
		
		restartButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				while(stop == true)
				{
					label.setText("");
					stopLabel.setText("");
					inputField.setEditable(true);
					
					run = true;
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
