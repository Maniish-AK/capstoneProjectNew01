package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class LogoutPage extends ProjectSpecificationMethods {

	@FindBy (xpath = "//td[contains(text(),'You have successfully logged out. ')]")
	WebElement logoutConfirmationMessage;
	
	public LogoutPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public LogoutPage validateLogout() {

		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("/Logout"), "User not logged out successfully.");
//		String logoutMessage = logoutConfirmationMessage.getText();
		Assert.assertTrue(logoutConfirmationMessage.getText().contains("You have successfully logged out. "), "User not logged out successfully.");
		return this;
	}
	

}
