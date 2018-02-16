package test_package;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public abstract class MyService extends Service<Void> implements Runnable
{
	private hud MyHud = new hud();
	
	private static String label = new String();
	
	private static Label randomLabel = new Label();
	
	public String getLabel()
	{
		return MyService.label;
	}
	
	public static void setLabel(Label label2)
	{
		label = label2.toString();
	}
	
	public MyService()
	{
		this.MyHud = MyHud;
	}
	
	@Override
	protected Task<Void> createTask()
	{
		return new Task<Void>()
		{
			@Override
			protected Void call() throws Exception
			{
				while(!label.equals("ERFOLG"))
				{
					getRandomLabel().setText("test");
				}
				return null;
			}
		};
	}

	public static Label getRandomLabel()
	{
		return randomLabel;
	}

	public void setRandomLabel(Label randomLabel)
	{
		this.randomLabel = randomLabel;
	}
}