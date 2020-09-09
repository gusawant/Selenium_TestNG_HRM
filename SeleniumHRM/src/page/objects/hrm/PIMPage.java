package page.objects.hrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import base.driver.test.BaseDriver;

public class PIMPage extends BaseDriver {

	public PIMPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "menu_pim_viewPimModule")
	WebElement PIMLink;

	@FindBy(id = "menu_pim_addEmployee")
	WebElement addEmployeeButton;

	@FindBy(id = "firstName")
	WebElement firstName;

	@FindBy(id = "lastName")
	WebElement lastName;

	@FindBy(id = "btnSave")
	WebElement saveButton;

	@FindBy(xpath = "//div[@id='profile-pic']/h1")
	WebElement profilePic;

	@FindBy(id = "menu_dashboard_index")
	WebElement dashboardLink;

	public void clickOnPIMLink() {

		if (dashboardLink.isEnabled()) {

			PIMLink.click();
			
		} else {

			dashboardLink.click();
			PIMLink.click();
		}

	}

	public void clickOnAddEmployeeButton() throws InterruptedException {
		
		Thread.sleep(3500);
		addEmployeeButton.click();
	}

	public void fillEmployeeDetails(String firstName, String lastName) {

		this.firstName.clear();
		this.firstName.sendKeys(firstName);

		this.lastName.clear();
		this.lastName.sendKeys(lastName);

		saveButton.click();

	}

	public void verifyEmployeeCreation(String employeeName) {

		String actualEmployeeName = profilePic.getText();

		String expectedEmployeeName = employeeName;

		Assert.assertEquals(expectedEmployeeName, actualEmployeeName);

	}

}
