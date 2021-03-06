package test_package;

import javafx.scene.control.TextField;

public class TextField_Begrenzer extends TextField
{	
	@Override
	public void replaceText(int start, int end, String text)
	{
		if(text.matches("[a-z]") && getText().length() <= 9 || text == "")
		{
			super.replaceText(start, end, text);
		}
	}
	
	@Override
	public void replaceSelection(String text)
	{
		if(text.matches("[a-z]") && getText().length() <= 9 || text == "")
		{
			super.replaceSelection(text);
		}
	}
}
