package live_package;

import java.util.Random;

public class RandomGen
{
	public static String RandomTextausgabe()
	{		
		char[] zahl = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		
		String text = new String();
		
		Random r2 = new Random();
		
		for(int i = 0; i < MainApp.getMeineZahl(); i++)
		{
			text = text + zahl[r2.nextInt(zahl.length)];
		}
		return text;
	}
}
