package test_package;

import java.util.Random;

public class das_affenprojekt_experimentieren
{

	public static void main(String[] args)
	{
		String nstring = new String();
		StringBuilder nstringb = new StringBuilder(30);
		//nstringb.setCharAt(1, (char) ('a' + 26*Math.random()));
		
		for (int i = 0; i < nstring.length(); i++)	//gibt jeden einzelnen Buchstabe pro Zeile aus
		{
			//System.out.println(nstring.charAt(i));
		}
		
		
		for (int i = 0; i < nstring.length(); i++)	//baut den String treppenartig auf
		{
			//System.out.println(nstring.substring(i));
		}
		//nRandom test = new nRandom();
		
		//System.out.println(nRandom);
		
		
	}//main Ende
	
	public String RandomTextausgabe() 
	{
		char[] zahl = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		String text = new String();
		//String hoden = text;
		
		System.out.println(zahl);
		
		text = "";
		Random r2 = new Random();
		
		for(int i = 0; i < text.length(); i++)
		{
			text = text + zahl[r2.nextInt(zahl.length)];
		}
		return text;
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
