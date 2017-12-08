package test_package;

import javafx.scene.control.TextField;

public class TextField_Begrenzer extends TextField
{
	public void replaceText(int start, int end, String text)
	{
		if(text.matches("[a-z]") && text.length() <= 10)
		{
			super.replaceText(start, end, text);
		}
	}
}
