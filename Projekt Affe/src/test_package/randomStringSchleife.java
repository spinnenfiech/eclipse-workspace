package test_package;

import javafx.application.Platform;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

public class randomStringSchleife // Nur experimentiert. Sonst unwichtig
{
	public static String testthread() throws InterruptedException
	{
		das_affenprojekt_experimentieren affe = new das_affenprojekt_experimentieren();
		return null;
	}
}

Thread t = new Thread()
{
	@SuppressWarnings("unlikely-arg-type")
	public void run()
	{					
		System.out.println("Pseudo Kontrolle aktiv");
		
		try
		{
			Thread.sleep(speed);
		}
		catch (InterruptedException e1)
		{
			e1.printStackTrace();
		}
			
		Platform.runLater(() ->
		{
			while(run == true)
			{			
				System.out.println("Having: " + label.getText() + 
						" | Looking for: " + inputField.getText() + 
						" | inputField length: " + inputField.getLength() + 
						" | meineZahl length: " + meineZahl + 
						" | getMeineZahl length: " + getMeineZahl());
				
				while(!inputField.getText().equals(label))
				{
					inputField.setEditable(false);
			
					label.setText(das_affenprojekt_experimentieren.RandomTextausgabe());
					
					if(winLabel.getText().equals("ERFOLG") || run == false)
					{
						break;
					}
					
					if(winLabel.getText().equals("ERFOLG"))
					{
						label.setText(inputField.getText());						
					}
				}
			}
		});
	};
	t.start();
	

	Platform.runLater(() ->
	{
		if(!inputField.getText().equals(label))
		{
			label.setText(das_affenprojekt_experimentieren.RandomTextausgabe());
		}
	});
	
	ScheduledService<Integer> service = new ScheduledService<Integer>()
		{
		@Override
		protected Task<Integer> createTask()
		{
			return new Task<Integer>()
			{
				@Override
				protected Integer call() throws Exception
				{
					Task task = new Task<Void>()
					{
						@Override
						public Void call()
						{
							System.out.println("Service läuft...");
							System.out.println("Having: " + label.getText() + 
									" | Looking for: " + inputField.getText() + 
									" | inputField length: " + inputField.getLength() + 
									" | meineZahl length: " + meineZahl + 
									" | getMeineZahl length: " + getMeineZahl());

							meineZahl = inputField.getLength();
						
							while(!winLabel.getText().equals("ERFOLG"))
							{
								label.setText(das_affenprojekt_experimentieren.RandomTextausgabe());
							
								if(winLabel.getText().equals("ERFOLG"))
								{
									break;
								}
							}
							return null;
						}
					};
					new Thread(task).start();
					return 0;
				}
						
			};
		}
			
		};