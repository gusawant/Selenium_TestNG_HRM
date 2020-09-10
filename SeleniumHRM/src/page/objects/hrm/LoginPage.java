package page.objects.hrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import base.driver.test.BaseDriver;
import utilities.Constants;

public class LoginPage extends BaseDriver {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div/img")
	WebElement headerImage;

	@FindBy(id = "txtUsername")
	WebElement userName;

	@FindBy(id = "txtPassword")
	WebElement userPassword;

	@FindBy(id = "btnLogin")
	WebElement loginButton;

	public void verifyPageTitle() {

		String title = driver.getTitle();

		System.out.println("Page title is: " + title);

		Assert.assertEquals(Constants.Login_Page_Title, title);

	}

	public void getHeaderImageURL() {

		String headerImageURL = headerImage.getAttribute("src");

		System.out.println(headerImageURL);
	}

	public void userLogin(String userName, String userPassword) {

		this.userName.clear();
		this.userName.sendKeys(userName);

		this.userPassword.clear();
		this.userPassword.sendKeys(userPassword);

		loginButton.click();

	}
}
