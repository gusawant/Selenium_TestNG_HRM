package test.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.driver.test.BaseTest;
import page.objects.hrm.LoginPage;
import page.objects.hrm.PIMPage;
import utilities.Constants;
import utilities.UserNameGenerator;

public class HRMTestCases extends BaseTest {

	@Test(priority = 0, enabled = false)
	public void verifyWebsiteTitle() {

		String title = driver.getTitle();

		System.out.println("Login Page title is: " + title);

		Assert.assertEquals(Constants.Login_Page_Title, title);

	}

	@Test(priority = 1, enabled = false)
	public void getHeaderImageURL() {

		LoginPage getURL = new LoginPage(driver);
		getURL.getHeaderImageURL();

	}

	@Test(priority = 2, enabled = false)
	public void login() {

		LoginPage userLogin = new LoginPage(driver);
		userLogin.userLogin(Constants.USER_NAME, Constants.USER_PASSWORD);

		String title = driver.getTitle();

		System.out.println("Home Page title is: " + title);

		Assert.assertEquals(Constants.Login_Page_Title, title);

	}

	@Test(priority = 3, enabled = false)
	public void addEmployee() throws InterruptedException {

		LoginPage userLogin = new LoginPage(driver);
		userLogin.userLogin(Constants.USER_NAME, Constants.USER_PASSWORD);

		PIMPage addEmp = new PIMPage(driver);
		addEmp.clickOnPIMLink();
		addEmp.clickOnAddEmployeeButton();

		UserNameGenerator empName = new UserNameGenerator();

		addEmp.fillEmployeeDetails(empName.firstName, empName.lastName);
		addEmp.verifyEmployeeCreation(empName.employeeName);

	}
}
