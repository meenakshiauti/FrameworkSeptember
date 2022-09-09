package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo1 {
	WebDriver driver;
	String empid;
	
	@Parameters("browsertype")
	@BeforeTest(groups= {"LoginPage"})
	public void setUp(String browsertype)
	{
		if(browsertype.equalsIgnoreCase("chrome"))
		{
//			System.setProperty("webdriver.chrome.driver", "F:\\Praful Sir Softech Class\\driver\\chromedriver.exe");
//			driver=new ChromeDriver();
			
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		
		else if(browsertype.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		else
		{
			System.out.println("Please provide proper browser");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		
	}
	
	@Parameters({"username","password"})
	@Test(priority=1,groups= {"LoginPage"})
	public void loginFunctionality(String uname, String pwd)
	{
		driver.findElement(By.id("txtUsername")).sendKeys(uname);
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("btnLogin")).click();
	}
	
	
	@Test(priority=2,dependsOnGroups = {"LoginPage"},groups = {"HomePage"})
	public void validateHomePageTitle()
	{
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@Test(priority=3,dependsOnGroups = {"LoginPage"},groups = {"HomePage"})
	public void validateHomePageUrl()
	{
		Assert.assertEquals(driver.getCurrentUrl().contains("hrm"), true);
	}
	
	@Test(priority=4,dependsOnGroups = {"LoginPage"},groups = {"HomePage"})
	public void validateLogo()
	{
		boolean logo= driver.findElement(By.xpath("//img[@alt='OrangeHRM']")).isDisplayed();
		Assert.assertEquals(logo,true);
	}
	
	@Test(priority=5,dependsOnGroups = {"HomePage"},groups = {"PIMPage"})
	public void validateUerisOnPimPAge()
	{
		driver.findElement(By.xpath("//b[text()='PIM']")).click();
		Assert.assertEquals(driver.getCurrentUrl().contains("pim"), true) ;
		
	}
	
	@Parameters({"fname","mname","lname"})
	@Test(priority=6,dependsOnGroups = "HomePage",groups = {"PIMPage"})
	public void createNewEmployee(String fname,String mname,String lname)
	{

		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("firstName")).sendKeys(fname);
		driver.findElement(By.id("middleName")).sendKeys(mname);
		driver.findElement(By.id("lastName")).sendKeys(lname);
		empid=driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();	
	}
	
	@Test(priority=7,dependsOnGroups = {"HomePage"},groups = {"PIMPage"})
	public void searchEmployeeonPIMPage()
	{
		driver.findElement(By.xpath("//b[text()='PIM']")).click();
		driver.findElement(By.id("empsearch_id")).sendKeys(empid);
		driver.findElement(By.id("searchBtn")).click();
	}
	
	@Test(priority=8,dependsOnGroups = {"HomePage"},groups = {"PIMPage"})
	public void deleteUser()
	{
		driver.findElement(By.xpath("//tbody//input[starts-with(@id,'ohrmList')]")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
	}

	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
}
