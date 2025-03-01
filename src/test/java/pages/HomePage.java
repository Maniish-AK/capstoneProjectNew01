package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.ProjectSpecificationMethods;

public class HomePage extends ProjectSpecificationMethods {

	@FindBy(id = "username")
	WebElement userNameField;

	@FindBy(id = "password")
	WebElement passwordField;

	@FindBy(id = "login")
	WebElement loginButton;

	@FindBy(xpath = "//b[contains(text(),'Invalid Login details or Your Password might have expired. ')]")
	WebElement loginErrorMessage;
	
	@FindBy(id = "username_show")
	WebElement welcomeMessage;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage enterUsername(String username) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(userNameField));
		userNameField.sendKeys(username);
		return this;
	}

	public HomePage enterPassword(String password) {

		passwordField.sendKeys(password);
		return this;

	}

	public HomePage clickLoginButton() {

		loginButton.click();
		return this;
	}

	public HomePage enterInvalidUsername() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(userNameField));
		userNameField.sendKeys("aabbcc");
		return this;
	}

	public HomePage clickLoginButtonForInvalid() {

		loginButton.click();
		return this;
	}

	public HomePage getLoginErrorMessage() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(loginErrorMessage));
		String errorMessage = loginErrorMessage.getText();
		;
		if (errorMessage.contains("Invalid Login details or Your Password might have expired. ")) {
			System.out.println("Invalid Credentials Used");
		}
		Assert.assertTrue(loginErrorMessage.isDisplayed(), "User should use valid credentials to Login.");
		return this;
	}

	public SearchHotelPage validateLogin(String testCase, String expected) {

		if (testCase.equals("ValidEmailAndValidPassword")) {

			@SuppressWarnings("deprecation")
			String loginMessage = welcomeMessage.getAttribute("value");

			Assert.assertEquals(loginMessage, expected);

		} else if (testCase.equals("InvalidEmailAndValidPassword")) {

			String actual = loginErrorMessage.getText();

			SoftAssert assertObj = new SoftAssert();
			assertObj.assertEquals(actual, expected);
			assertObj.assertAll();
		}
		return new SearchHotelPage(driver);
	}

}
