package test_package;

import java.util.Random;

public class das_affenprojekt_experimentieren //extends Label
{
	public static String RandomTextausgabe() //throws InterruptedException //Die Methode, das zuf�llige CharArray zu bauen
	{		
		char[] zahl = "abcdefghijklmnopqrstuvwxyz".toCharArray(); //Das Alphabet als Pool f�r das Array
		
		String text = new String();
		
		Random r2 = new Random(); //Der Zufalls-Affe
		
		for(int i = 0; i < hud.getMeineZahl(); i++) //Die Schleife, um das Array mit zuf�lligen Charakteren zu f�llen
		{
			System.out.println("Das ist 'inputFieldL�nge': " + hud.getMeineZahl());
			text = text + zahl[r2.nextInt(zahl.length)];
		}
		return text;
	}
}