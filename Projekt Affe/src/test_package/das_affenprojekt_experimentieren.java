package test_package;

import java.util.Random;

public class das_affenprojekt_experimentieren
{

	public static void main(String[] args)
	{
		String nstring = new String(RandomTextausgabe(30));
		String nstring2 = new String(RandomTextausgabe2(30));
		System.out.println(nstring);
		StringBuilder nstringb = new StringBuilder(30);
		String temporärstring = new String();
		//nstringb.setCharAt(1, (char) ('a' + 26*Math.random()));
		int f = 0;
		while(true)
		{
			nstring.replaceAll(nstring, temporärstring);
			nstring2.replaceAll(temporärstring, nstring);
			f++;
			//System.out.println(f);
		}
		
		//for (int i = 0; i < nstring.length(); i++)	//gibt jeden einzelnen Buchstabe pro Zeile aus
		//{
			//System.out.println(nstring.charAt(i));
		//}
		
		
		//for (int i = 0; i < nstring.length(); i++)	//baut den String treppenartig auf
		//{
			//System.out.println(nstring.substring(i));
		//}
		//nRandom test = new nRandom();
		//System.out.println(nRandom);
		
		
	}//main Ende
	
	public static String RandomTextausgabe(int j) 
	{
		char[] zahl = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		String text = "";
		Random r2 = new Random();
			for(int i = 0; i < zahl.length; i++)
			{
				text = text + zahl[r2.nextInt(zahl.length)];
			}
			System.out.println(text);
			System.out.println(text.length());
			return text;
	}
	
	public static String RandomTextausgabe2(int j) 
	{
		char[] zahl = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		String text = "";
		Random r2 = new Random();
		while(true)
		{
			for(int i = 0; i < zahl.length; i++)
			{
				text = text + zahl[r2.nextInt(zahl.length)];
			}
			System.out.println(text);
			System.out.println(text.length());
			return text;
		}
	}
	
	public static StringBuilder nRandom;
	{
		StringBuilder nRandomFill = new StringBuilder();
		//nRandomFill.setCharAt(1, (char) ('a' + 26*Math.random()));
		String nStringIrgendwas = nRandomFill.toString();
		
		nRandom.setLength(30);
		nRandom.replace(1, 30, nStringIrgendwas);
		
		String nstring = new String("das ist ein Test");
		
		for (int i = 0; i < nstring.length(); i++)	//gibt jeden einzelnen Buchstabe pro Zeile aus
		{
			System.out.println(nstring.charAt(i));
		}
		
	}
}
