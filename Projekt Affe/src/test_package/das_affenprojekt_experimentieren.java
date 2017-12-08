package test_package;

import java.util.Random;

public class das_affenprojekt_experimentieren
{
	public static String RandomTextausgabe() //Die Methode, das zufällige CharArray zu bauen
	{
		char[] zahl = "abcdefghijklmnopqrstuvwxyz".toCharArray(); //Das Alphabet als Pool für das Array
		String text = new String(); //Die länge des Arrays
		Random r2 = new Random(); //Der Zufalls-Affe
		for(int i = 0; i < text.length(); i++) //Die Schleife, um das Array mit zufälligen Charakteren zu füllen
		{
			text = text + zahl[r2.nextInt(zahl.length)];
		}
		return text;
	}
}