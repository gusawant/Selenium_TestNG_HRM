package page.objects.hrm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import base.driver.test.BaseDriver;
import utilities.Constants;

public class MyInfoPage extends BaseDriver {

	public MyInfoPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "menu_pim_viewMyDetails")
	WebElement myInfoLink;

	@FindBy(id = "btnSave")
	WebElement saveButton;

	@FindBy(id = "personal_txtEmpFirstName")
	WebElement empFirstName;

	@FindBy(id = "personal_txtEmpLastName")
	WebElement empLastName;

	@FindBy(id = "personal_optGender_1")
	WebElement genderMale;

	@FindBy(id = "personal_optGender_2")
	WebElement genderFemale;

	@FindBy(id = "personal_cmbNation")
	WebElement nationality;

	@FindBy(id = "personal_DOB")
	WebElement dob;

	@FindBy(id = "menu_dashboard_index")
	WebElement dashboardLink;
	
	@FindBy(xpath = "//a[contains(@href,'Qualifications')]")
	WebElement qualificationsLink;
	
	@FindBy(id = "addWorkExperience")
	WebElement addWorkExperienceButton;
	
	@FindBy(id = "experience_employer")
	WebElement company;
	
	@FindBy(id = "experience_jobtitle")
	WebElement jobTitle;
	
	@FindBy(id = "experience_from_date")
	WebElement fromDate;
	
	@FindBy(id = "experience_to_date")
	WebElement toDate;
	
	@FindBy(id = "experience_comments")
	WebElement comment;
	
	@FindBy(id = "btnWorkExpSave")
	WebElement workExpSaveButton;
	
	@FindBy(xpath = "//a[contains(@href,'EmergencyContacts')]")
	WebElement emergencyContactsLink;

	public void clickOnMyInfoLink() {

		if (dashboardLink.isEnabled()) {

			myInfoLink.click();

		} else {

			dashboardLink.click();
			myInfoLink.click();
		}

	}

	public void fillEmployeeDetails(String empFirstName, String empLastName) {

		this.empFirstName.clear();
		this.empFirstName.sendKeys(empFirstName);

		this.empLastName.clear();
		this.empLastName.sendKeys(empLastName);		

	}

	public void selectGender() {

		if (genderMale.isSelected()) {

			genderFemale.click();
		} else {
			genderMale.click();
		}
	}

	public void selectNationality() throws InterruptedException {

		Select selectNation = new Select(nationality);
		selectNation.selectByValue("0");
		Thread.sleep(2500);
		selectNation.selectByValue("4");
	}

	public void enterDOB() {

		dob.clear();
		dob.sendKeys("1990-01-01");
		dob.sendKeys(Keys.ENTER);
	}
	
	public void clickOnSaveButton() {
		
		saveButton.click();
	}
	
	public void clickOnQualificationsLink() {
		
		qualificationsLink.click();
	}
	
	public void clickOnAddWorkExpButton() {
		
		addWorkExperienceButton.click();
	}
	
	public void fillWorkExp(String company, String jobTitle) {
		
		this.company.clear();
		this.company.sendKeys(company);
		
		this.jobTitle.clear();
		this.jobTitle.sendKeys(jobTitle);
		
		fromDate.clear();
		fromDate.sendKeys("2010-01-01");
		fromDate.sendKeys(Keys.ENTER);
		
		toDate.clear();
		toDate.sendKeys("2015-12-31");
		toDate.sendKeys(Keys.ENTER);
		
		comment.clear();
		comment.sendKeys(Constants.Comments);
		
		workExpSaveButton.click();
	}
	
	public void clickOnEmergencyContactsLink() {
		
		emergencyContactsLink.click();		
		
	}
	
	public void printEmergencyContactsList() {
		
		WebElement thead = driver.findElement(By.xpath("//table[@id='emgcontact_list']/thead"));
		
		System.out.println(thead.getText());
		
		WebElement tbody = driver.findElement(By.xpath("//table[@id='emgcontact_list']/tbody"));

		List<WebElement> trows = tbody.findElements(By.tagName("tr"));

		for (int i = 0; i < trows.size(); i++) {
			List<WebElement> tcells = trows.get(i).findElements(By.tagName("td"));

			for (int j = 0; j < tcells.size(); j++) {
				System.out.print(tcells.get(j).getText() + " ");
			}
			System.out.println();
		}
	}
}
