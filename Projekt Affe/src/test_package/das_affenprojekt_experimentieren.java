package test_package;

import java.util.Random;

import javafx.scene.control.Label;

public class das_affenprojekt_experimentieren //extends Label
{
	public String RandomTextausgabe() throws InterruptedException //Die Methode, das zuf�llige CharArray zu bauen
	{
		hud inputFieldL�nge = new hud();
		
		char[] zahl = "abcdefghijklmnopqrstuvwxyz".toCharArray(); //Das Alphabet als Pool f�r das Array
		
		String text = new String();
		
		Random r2 = new Random(); //Der Zufalls-Affe
		
		for(int i = 0; i < 4; i++) //Die Schleife, um das Array mit zuf�lligen Charakteren zu f�llen
		{
			text = text + zahl[r2.nextInt(zahl.length)];
		}
		return text;
	}
}