package com.UtilsLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BaseLayer.BaseClass;

public class FrameMethods extends BaseClass {
	
	public static WebDriver switchToframeByIndex(int index)
	{
		return driver.switchTo().frame(index);
	}

	public static WebDriver switchToframeByIdOrName(String nameorId)
	{
		return driver.switchTo().frame(nameorId);
	}
	
	public static WebDriver switchToframeBywebElemt(WebElement wb)
	{
		return driver.switchTo().frame(wb);
	}
	
	public static WebDriver switchToParentFrame()
	{
		return driver.switchTo().parentFrame();
	}
	
	public static WebDriver switchToTopFrame()
	{
		return driver.switchTo().defaultContent();
	}

}
