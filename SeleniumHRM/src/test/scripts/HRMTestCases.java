package test.scripts;

import org.testng.annotations.Test;

import base.driver.test.BaseTest;
import page.objects.hrm.DashboardPage;
import page.objects.hrm.DirectoryPage;
import page.objects.hrm.LoginPage;
import page.objects.hrm.MyInfoPage;
import page.objects.hrm.PIMPage;
import utilities.Constants;
import utilities.RandomValueGenerator;

public class HRMTestCases extends BaseTest {

	@Test(priority = 0, enabled = true)
	public void verifyWebsiteTitle() {

		LoginPage verifyPageTitle = new LoginPage(driver);
		verifyPageTitle.verifyPageTitle();
		
	}

	@Test(priority = 1, enabled = true)
	public void getHeaderImageURL() {

		LoginPage getURL = new LoginPage(driver);
		getURL.getHeaderImageURL();

	}

	@Test(priority = 2, enabled = true)
	public void login() {

		LoginPage userLogin = new LoginPage(driver);
		userLogin.userLogin(Constants.USER_NAME, Constants.USER_PASSWORD);
		userLogin.verifyPageTitle();
		
	}

	@Test(priority = 3, enabled = true)
	public void addEmployee() throws InterruptedException {

		LoginPage userLogin = new LoginPage(driver);
		userLogin.userLogin(Constants.USER_NAME, Constants.USER_PASSWORD);

		PIMPage addEmp = new PIMPage(driver);
		addEmp.clickOnPIMLink();
		addEmp.clickOnAddEmployeeButton();

		RandomValueGenerator empName = new RandomValueGenerator();

		addEmp.fillEmployeeDetails(empName.firstName, empName.lastName);
		addEmp.verifyEmployeeCreation(empName.employeeName);

	}
	
	@Test(priority = 4, enabled = true)
	public void editUserInformation() throws InterruptedException {
		
		LoginPage userLogin = new LoginPage(driver);
		userLogin.userLogin(Constants.USER_NAME, Constants.USER_PASSWORD);

		MyInfoPage myInfo = new MyInfoPage(driver);
		myInfo.clickOnMyInfoLink();
		myInfo.clickOnSaveButton();
		
		RandomValueGenerator empName = new RandomValueGenerator();
		
		myInfo.fillEmployeeDetails(empName.firstName, empName.lastName);
		myInfo.selectGender();
		myInfo.selectNationality();
		myInfo.enterDOB();
		myInfo.clickOnSaveButton();
		
	}
	
	@Test(priority = 5, enabled = true)
	public void verifyDirectoryHeader() {
		
		LoginPage userLogin = new LoginPage(driver);
		userLogin.userLogin(Constants.USER_NAME, Constants.USER_PASSWORD);

		DirectoryPage directory = new DirectoryPage(driver);
		directory.clickOnDirectoryLink();
		directory.verifyHeader();
	}
	
	@Test(priority = 6, enabled = true)
	public void addworkExperience() {
		
		LoginPage userLogin = new LoginPage(driver);
		userLogin.userLogin(Constants.USER_NAME, Constants.USER_PASSWORD);
		
		MyInfoPage addWorkExp = new MyInfoPage(driver);
		addWorkExp.clickOnMyInfoLink();
		addWorkExp.clickOnQualificationsLink();
		addWorkExp.clickOnAddWorkExpButton();
		
		RandomValueGenerator empName = new RandomValueGenerator();
		
		addWorkExp.fillWorkExp(empName.companyName, Constants.Job_Title);
				
	}
	
	@Test(priority = 7, enabled = true)
	public void applyForLeave() throws InterruptedException {
		
		LoginPage userLogin = new LoginPage(driver);
		userLogin.userLogin(Constants.USER_NAME, Constants.USER_PASSWORD);
		
		DashboardPage applyLeave = new DashboardPage(driver);
		applyLeave.clickOnApplyLeaveLink();
		applyLeave.applyLeave();
		applyLeave.myLeave();
	}	
	
	@Test(priority = 8, enabled = true)
	public void printEmergencyContacts() {
		
		LoginPage userLogin = new LoginPage(driver);
		userLogin.userLogin(Constants.USER_NAME, Constants.USER_PASSWORD);
		
		MyInfoPage printList = new MyInfoPage(driver);
		printList.clickOnMyInfoLink();
		printList.clickOnEmergencyContactsLink();
		printList.printEmergencyContactsList();
	}
}
