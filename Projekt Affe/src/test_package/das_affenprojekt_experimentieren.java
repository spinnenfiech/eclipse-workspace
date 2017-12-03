package test_package;

import java.util.Random;

public class das_affenprojekt_experimentieren
{

	public static void main(String[] args)
	{
		while(true) //Die Schleife, um das unten angegebene CharArray unendlich oft herzugeben
		{
			System.out.println(RandomTextausgabe());
		}
	} //Main Ende
	
	public static char[] RandomTextausgabe() //Die Methode, das zuf�llige CharArray zu bauen
	{
		char[] zahl = "abcdefghijklmnopqrstuvwxyz".toCharArray(); //Das Alphabet als Pool f�r das Array
		char[] text = new char[30]; //Die l�nge des Arrays
		Random r2 = new Random(); //Der Zufalls-Affe
		for(int i = 0; i < text.length; i++) //Die Schleife, um das Array mit zuf�lligen Charakteren zu f�llen
		{
			text[i] = zahl[r2.nextInt(zahl.length)];
		}
		return text;
	}
}
