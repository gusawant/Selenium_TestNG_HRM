package base.driver.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utilities.Constants;

public abstract class BaseTest {
	
	public WebDriver driver;
	
	@BeforeTest
	public void startBrowser() {
		
		System.setProperty("webdriver.chrome.driver", Constants.Driver_Path);
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(Constants.OrangeHRM_URL);
		
		driver.manage().window().maximize();		
	
	}
	
	@AfterTest
	public void closeBrowser() {
		
		driver.close();
	}

}
