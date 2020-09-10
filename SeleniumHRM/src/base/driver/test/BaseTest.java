package base.driver.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.Constants;

public abstract class BaseTest {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void startBrowser() {
		
		System.setProperty("webdriver.chrome.driver", Constants.Driver_Path);
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(Constants.OrangeHRM_URL);
		
		driver.manage().window().maximize();		
	
	}
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.close();
	}

}
