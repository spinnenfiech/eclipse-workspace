package test_package;

import java.util.Random;

public class das_affenprojekt_experimentieren //extends Label
{
	public static String RandomTextausgabe() //throws InterruptedException //Die Methode, das zufällige CharArray zu bauen
	{		
		char[] zahl = "abcdefghijklmnopqrstuvwxyz".toCharArray(); //Das Alphabet als Pool für das Array
		
		String text = new String();
		
		Random r2 = new Random(); //Der Zufalls-Affe
		
		for(int i = 0; i < hud.getMeineZahl(); i++) //Die Schleife, um das Array mit zufälligen Charakteren zu füllen
		{
			System.out.println("Das ist 'inputFieldLänge': " + hud.getMeineZahl());
			text = text + zahl[r2.nextInt(zahl.length)];
		}
		return text;
	}
}