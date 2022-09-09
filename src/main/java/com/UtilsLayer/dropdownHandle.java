package com.UtilsLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class dropdownHandle {
	
	public void selectByVisibleText(WebElement wb, String text)
	{
		Select sel=new Select(wb);
		sel.selectByVisibleText(text);
	}
	
	public void selectByIndex(WebElement wb, int index)
	{
		Select sel=new Select(wb);
		sel.selectByIndex(index);
	}

	public void selectByValue(WebElement wb, String value)
	{
		Select sel=new Select(wb);
		sel.selectByValue(value);
	}
}
