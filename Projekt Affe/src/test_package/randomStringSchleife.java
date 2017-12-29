package test_package;

public class randomStringSchleife
{
	public static String testthread() throws InterruptedException
	{
		das_affenprojekt_experimentieren affe = new das_affenprojekt_experimentieren();
		
		while(true)
		{
			Thread.sleep(10);
			affe.RandomTextausgabe();
		}
	}
}
