package page.objects.hrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import base.driver.test.BaseDriver;
import utilities.Constants;

public class DirectoryPage extends BaseDriver {

	public DirectoryPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "menu_directory_viewDirectory")
	WebElement directoryLink;
	
	@FindBy(xpath = "//div[@class='head']/h1")
	WebElement directoryPageHeader;
	
	public void clickOnDirectoryLink() {
		
		if(directoryLink.isDisplayed()) {
			
			directoryLink.click();
		}
		else {
			System.out.println("Directory menu item is not visible.");
		}
	}
	
	public void verifyHeader() {
		
		String actualHeader = directoryPageHeader.getText();
		
		Assert.assertEquals(actualHeader, Constants.Directory_Page_Header);
	}

}
