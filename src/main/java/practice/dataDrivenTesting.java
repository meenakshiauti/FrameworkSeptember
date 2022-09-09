package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.UtilsLayer.dropdownHandle;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dataDrivenTesting {
	
	XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	

	public dataDrivenTesting(String filePath) throws Exception
	{
		File f=new File(filePath);
		System.out.println(f.exists());
		FileInputStream fis=new FileInputStream(f);
		workbook=new XSSFWorkbook(fis);
	}
	
	public String captureDataFromExcel(int sheetIndex,int rows,int cells)
	{
		sheet= workbook.getSheetAt(sheetIndex);
		try {
			return sheet.getRow(rows).getCell(cells).getStringCellValue();
		}
		
		catch(Exception e)
		{
			double d = sheet.getRow(rows).getCell(cells).getNumericCellValue();

			long abc = (long) d;

			return Long.toString(abc);
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/reg");
		
		dataDrivenTesting obj=new dataDrivenTesting("F:\\Praful Sir Softech Class\\Excel Data Sheets\\userDataForFacebookRegistration.xlsx");
		String fname=obj.captureDataFromExcel(0, 2, 0);
		driver.findElement(By.name("firstname")).sendKeys(fname);
		
		String lname=obj.captureDataFromExcel(0, 2, 1);
		driver.findElement(By.name("lastname")).sendKeys(lname);
		
		String mobNo=obj.captureDataFromExcel(0, 2, 2);
		driver.findElement(By.name("reg_email__")).sendKeys(mobNo);
		
		String pwd=obj.captureDataFromExcel(0, 2, 3);
		driver.findElement(By.name("reg_passwd__")).sendKeys(pwd);
		
		dropdownHandle drp=new dropdownHandle();
		
		WebElement day=driver.findElement(By.id("day"));
		drp.selectByVisibleText(day, obj.captureDataFromExcel(0, 2, 4));
		
		WebElement month=driver.findElement(By.id("month"));
		drp.selectByVisibleText(month, obj.captureDataFromExcel(0, 2, 5));
		
		WebElement year=driver.findElement(By.id("year"));
		drp.selectByVisibleText(year, obj.captureDataFromExcel(0, 2, 6));
		
		Row row = sheet.getRow(2);
	    Cell cell = row.getCell(7);
	    
	    if (cell.toString().contentEquals("Male")) {
	        WebElement male_radio_button = driver.findElement(By.xpath("//input[@value='2']"));
	        male_radio_button.click();
	    } else {
	        WebElement female_radio_button = driver.findElement(By.xpath("//input[@value='1']"));
	        female_radio_button.click();
		
	    }	
	}
}
