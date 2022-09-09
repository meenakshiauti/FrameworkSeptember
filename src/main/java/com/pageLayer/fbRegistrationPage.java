package com.pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseLayer.BaseClass;
import com.UtilsLayer.dropdownHandle;
import com.UtilsLayer.utilsClass;


public class fbRegistrationPage extends BaseClass{
	
	public fbRegistrationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "firstname")
	WebElement fname;
	
	@FindBy(name = "lastname")
	WebElement lname;

	@FindBy(name = "reg_email__")
	WebElement mailOrMob;
	
	@FindBy(name = "reg_passwd__")
	WebElement pwd;
	
	@FindBy(id = "day")
	WebElement day1;
	
	@FindBy(id = "month")
	WebElement month1;
	
	@FindBy(id = "year")
	WebElement year1;
	
	@FindBy(xpath="//label[contains(text(),'Female')]")
	WebElement femaleGender;
	
	@FindBy(xpath="//label[contains(text(),'Male')]")
	WebElement maleGender;
	
	
	public void registerUserOfPageClass(String firstname,String lastname,String mobileOrMail,String password,String day,String month,String year,String gender) throws Exception
	{
		
	    fname.sendKeys(firstname);
	    lname.sendKeys(lastname);
	    mailOrMob.sendKeys(mobileOrMail);
	    pwd.sendKeys(password);
	    
	    dropdownHandle drp=new dropdownHandle();
	    
		drp.selectByVisibleText(day1, day);
	    drp.selectByVisibleText(month1, month);
		drp.selectByVisibleText(year1, year);

	    if (gender.contentEquals("Male")) {
	       maleGender.click();
	    } else {
	       femaleGender.click();
		
	    }	
	    
	    utilsClass util=new utilsClass();
	    util.takesScreenshot("fbRegistration");
	    
	    System.out.println("Screenshot captured Successfully");
	    
	   driver.navigate().refresh();
	    
	    
	    
	    
	    
	}
}
