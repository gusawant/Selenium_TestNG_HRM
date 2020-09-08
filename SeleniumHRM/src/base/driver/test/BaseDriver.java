package base.driver.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseDriver {

	public WebDriver driver;

	public BaseDriver(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

}
