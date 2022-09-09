package com.UtilsLayer;

import com.BaseLayer.BaseClass;

public class AlertMethods extends BaseClass {

	public static void clickOnOkButton()
	{
		driver.switchTo().alert().accept();
	}
	
	public static void clickOnCancelButton()
	{
		driver.switchTo().alert().dismiss();
	}
	
	public static void sendDataToAlert(String value)
	{
		driver.switchTo().alert().sendKeys(value);
	}
	
	public static void getDataFromAlert()
	{
		driver.switchTo().alert().getText();
	}
}
