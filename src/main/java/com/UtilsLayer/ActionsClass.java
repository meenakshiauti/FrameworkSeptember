package com.UtilsLayer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.BaseLayer.BaseClass;

public class ActionsClass extends BaseClass{
	
	public static void clickOnElement(WebElement wb)
	{
		new Actions(driver).click(wb).build().perform();
	}
	
	public static void doubleClick(WebElement wb)
	{
		new Actions(driver).doubleClick(wb).build().perform();
	}
	
	public static void rightClickonElement(WebElement wb)
	{
		new Actions(driver).contextClick(wb).build().perform();
	}
	
	public static void dragAndDrop(WebElement src,WebElement trg)
	{
		new Actions(driver).dragAndDrop(src, trg).build().perform();
	}
	
	public static void mouseHower(WebElement wb)
	{
		new Actions(driver).moveToElement(wb).build().perform();
	}
	
	public static void clickAndHold(WebElement wb)
	{
		new Actions(driver).clickAndHold(wb).build().perform();
	}

	public static void releaseElement(WebElement wb)
	{
		new Actions(driver).release(wb).build().perform();
	}
	
	public static void enterCapitalLetters(WebElement wb, String value)
	{
		new Actions(driver).keyDown(Keys.SHIFT).sendKeys(wb,value).build().perform();
	}
	
	public static void moveToEndOfPage() 
	{
		new Actions(driver).keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
	}
	
	public  static  void moveToHomepage() 
	{
		new Actions(driver).keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
	}
}
