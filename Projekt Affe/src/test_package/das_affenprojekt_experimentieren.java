package test_package;

import java.util.Random;

import javafx.scene.control.Label;

public class das_affenprojekt_experimentieren //extends Label
{
	static hud inputFieldLänge = new hud();
	
	public static String RandomTextausgabe() throws InterruptedException //Die Methode, das zufällige CharArray zu bauen
	{		
		char[] zahl = "abcdefghijklmnopqrstuvwxyz".toCharArray(); //Das Alphabet als Pool für das Array
		
		String text = new String();
		
		Random r2 = new Random(); //Der Zufalls-Affe
		
		for(int i = 0; i < 4; i++) //Die Schleife, um das Array mit zufälligen Charakteren zu füllen
		{
			System.out.println("Das ist 'inputFieldLänge': " + inputFieldLänge.getMeineZahl());
			text = text + zahl[r2.nextInt(zahl.length)];
		}
		return text;
	}
}