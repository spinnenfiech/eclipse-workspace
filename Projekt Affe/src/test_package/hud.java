package test_package;

import javafx.event.ActionEvent;

import com.sun.javafx.scene.paint.GradientUtils.Point;
import com.sun.xml.internal.ws.wsdl.writer.document.Port;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class hud extends Application //Meine Hauptausf�hrung mit der Main
{
	public int meineZahl = 4;
	
	@Override
	public void start(Stage firstStage) throws InterruptedException
	{	
		das_affenprojekt_experimentieren affe = new das_affenprojekt_experimentieren();
		
		VBox windowVBox = new VBox();
		Scene firstScene = new Scene(windowVBox, 500, 250);
		Button startButton = new Button();
		Button restartButton = new Button();
		TextField_Begrenzer inputField = new TextField_Begrenzer(); //Limitiert auf nur max. 10 Anschl�ge und nur a-z
		//inputField.textProperty().addListener((to, from, o) -> 
		//this.meineZahl = inputField.getText().length();
		Label winLabel = new Label();
		Label percentageLabel = new Label(); //Eine Prozentanzeige, wie viel des gesuchten Wortes schon mal �bereinstimmten. Bei 100% hat man quasi gewonnen (in progress)
		Label timeLabel = new Label(); //Eine Zeitanzeige, welche beim Start dr�cken anf�ngt und bei 100% aufh�rt
		Label label = new Label(); //Mein Affe, welcher mir wahllose Buchstaben in dieses Label f�llt
		
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
		
		if(!inputField.getText().equals(label.getText())) //Eine Anzeige, dass das TextField leer ist
		{
			winLabel.setText("warte auf Eingabe");
		}
		
		label.textProperty().addListener(new ChangeListener<String>() //Meine �berpr�fung, ob das gesuchte Wort schon im label gefunden worden ist. Funktioniert, wurde aber noch nicht mit dem label ausprobiert
		{
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
			{
				if(inputField.getText().equals(label.getText())) //Die Ausgabe, ob das eingegebene Wort gefunden wurde
				{
					winLabel.setText("ERFOLG");
				}
				else
				{
					winLabel.setText("warte auf Ergebnis"); //Quasi wie die if-Abfrage oben, nur dass dies erst kommt, wenn in das TextField getippt wurde
				}
			}
		});
		
		startButton.setOnAction(new EventHandler<ActionEvent>() //Die Aktion, was passiert, wenn ich Start dr�cke. Hier ist das Problem, dass ich das Label nicht die ganze Zeit neu beschreiben kann. Hier h�ngt sich trotz Thread.sleep das Fenster auf und es bringt keine R�ckmeldung
		{				
			@Override
			public void handle(ActionEvent e)
			{					
				Thread t = new Thread()
				{
					public void run()
					{
						while(!inputField.getText().equals(label.getText()))
						{
							System.out.println("Having: " + label.getText() + " | Looking for: " + inputField.getText());
							try {
								label.setText(affe.RandomTextausgabe());
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				};
				t.start();			
			}
		});
	}
	
	public void setMeineZahl(int neueZahl)
	{
		this.meineZahl = neueZahl;
	}

	public int getMeineZahl()
	{
		return this.meineZahl;
	}
	
	public static void main(String[] args)
	{
		launch();
	}
}
