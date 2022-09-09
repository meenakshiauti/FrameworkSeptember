package com.TestLayer;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BaseLayer.BaseClass;
import com.UtilsLayer.excelReaderClass;
import com.pageLayer.fbRegistrationPage;

public class fbRegistrationTest extends BaseClass{
	
	fbRegistrationPage fbRegistrationPage;
	
	@BeforeClass
	public void setUp() {
		BaseClass.inilitization();
		fbRegistrationPage=new fbRegistrationPage();
		
	}
	
	@Test(priority=1,dataProvider="fbData")
	public void registerUserOfTest(String firstname,String lastname,String mobileOrMail,String password,String day,String month,String year,String gender) throws Exception
	{

		fbRegistrationPage.registerUserOfPageClass(firstname, lastname, mobileOrMail, password, day, month, year, gender);
		
	}
	
	@DataProvider(name="fbData")
	public Object[][] getData() throws Exception
	{
		
		excelReaderClass excel=new excelReaderClass("F:\\Praful Sir Softech Class\\Excel Data Sheets\\userDataForFacebookRegistration.xlsx");
		int rows=excel.countRows(0);
		int cells=excel.countCells(0);
		
		Object[][] data=new Object[rows][cells];
		
		for(int i=0;i<rows;i++)
		{
			data[i][0]=excel.captureDataFromExcel(0, i, 0);
			data[i][1]=excel.captureDataFromExcel(0, i, 1);
			data[i][2]=excel.captureDataFromExcel(0, i, 2);
			data[i][3]=excel.captureDataFromExcel(0, i, 3);
			data[i][4]=excel.captureDataFromExcel(0, i, 4);
			data[i][5]=excel.captureDataFromExcel(0, i, 5);
			data[i][6]=excel.captureDataFromExcel(0, i, 6);
			data[i][7]=excel.captureDataFromExcel(0, i, 7);
			
		}
		
		return data;
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
