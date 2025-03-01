package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class BookHotelPage extends ProjectSpecificationMethods {

	@FindBy(id = "first_name")
	WebElement firstNameField;

	@FindBy(id = "last_name")
	WebElement lastNameField;

	@FindBy(id = "address")
	WebElement addressField;

	@FindBy(id = "cc_num")
	WebElement creditcardField;

	@FindBy(id = "cc_type")
	WebElement cardTypeDropDown;

	@FindBy(id = "cc_exp_month")
	WebElement monthExpiryDropDown;

	@FindBy(id = "cc_exp_year")
	WebElement yearExpiryDropDown;

	@FindBy(id = "cc_cvv")
	WebElement cvvField;

	@FindBy(id = "book_now")
	WebElement booknowButton;

	@FindBy(id = "cancel")
	WebElement cancelButton;

	@FindBy(xpath = "//a[contains(text(),'Back')]")
	WebElement backButton;

	@FindBy(xpath = "//a[contains(text(),'Please wait! We are processing your Hotel Booking...')]")
	WebElement processingMessage;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logoutButton;

	@FindBy(xpath = "//label[@id='cc_num_span']")
	WebElement ccErrorMessage;

	@FindBy(xpath = "//label[@id='cc_type_span']")
	WebElement cctypeErrorMessage;

	@FindBy(xpath = "//label[@id='cc_expiry_span']")
	WebElement ccexpiryErrorMessage;

	@FindBy(xpath = "//label[@id='cc_cvv_span']")
	WebElement cvvErrorMessage;

	public BookHotelPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public BookHotelPage enterFirstName(String firstname) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(firstNameField));
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("/BookHotel")) {
			Assert.assertTrue(currentUrl.contains("/BookHotel"), "User not logged in successfully.");
			firstNameField.sendKeys(firstname);
		}
		return this;
	}

	public BookHotelPage enterLastName(String lastname) {

		lastNameField.sendKeys(lastname);
		return this;
	}

	public BookHotelPage enterAddress(String address) {

		addressField.sendKeys(address);
		return this;
	}

	public BookHotelPage enterCreditCardNo(String ccno) {

		creditcardField.sendKeys(ccno);
		return this;
	}

	public BookHotelPage enterCreditcardType(String cctype) {
		cardTypeDropDown.click();
		waitForTime(1000);
		List<WebElement> myCcTypeElements = driver.findElements(By.xpath("//select[@id='cc_type']//option"));
		for (int index = 0; index < myCcTypeElements.size(); index++) {
			if (myCcTypeElements.get(index).getText().equalsIgnoreCase(cctype)) {
				myCcTypeElements.get(index).click();
				break;
			}
		}
		return this;
	}

	public BookHotelPage enterCreditcardExpMonth(String ccexpmonth) {
		monthExpiryDropDown.click();
		waitForTime(1000);
		List<WebElement> myMonthExpElements = driver.findElements(By.xpath("//select[@id='cc_exp_month']//option"));
		for (int index = 0; index < myMonthExpElements.size(); index++) {
			if (myMonthExpElements.get(index).getText().equalsIgnoreCase(ccexpmonth)) {
				myMonthExpElements.get(index).click();
				break;
			}
		}
		return this;
	}

	public BookHotelPage enterCreditcardExpYear(String ccexpyear) {
		yearExpiryDropDown.click();
		waitForTime(1000);
		List<WebElement> myYearExpElements = driver.findElements(By.xpath("//select[@id='cc_exp_year']//option"));
		for (int index = 0; index < myYearExpElements.size(); index++) {
			if (myYearExpElements.get(index).getText().equalsIgnoreCase(ccexpyear)) {
				myYearExpElements.get(index).click();
				break;
			}
		}
		return this;
	}

	public BookHotelPage enterCvvNo(String cvv) {

		cvvField.sendKeys(cvv);
		return this;
	}

	public BookConfirmPage clickBookNowButton() {

		booknowButton.click();
		return new BookConfirmPage(driver);
	}

	public BookHotelPage clickBookNowButtonForInvalid() {

		booknowButton.click();
		return this;
	}

	public BookHotelPage getccErrorMessage() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ccErrorMessage));
		String creditcardErrorMessage = ccErrorMessage.getText();
		;
		if (creditcardErrorMessage.contains("Please Enter your 16 Digit Credit Card Number")) {
			System.out.println("Credit Card No is Mandatory");
		}
		Assert.assertTrue(ccErrorMessage.isDisplayed(), "User should enter valid details to search hotel.");
		return this;
	}

	public BookHotelPage getcctypeErrorMessage() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(cctypeErrorMessage));
		String creditcardTypeErrorMessage = cctypeErrorMessage.getText();
		;
		if (creditcardTypeErrorMessage.contains("Please Select your Credit Card Type")) {
			System.out.println("Credit Card Type is Mandatory");
		}
		Assert.assertTrue(cctypeErrorMessage.isDisplayed(), "User should enter valid details to search hotel.");
		return this;
	}

	public BookHotelPage getExpiryErrorMessage() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ccexpiryErrorMessage));
		String creditcardExpiryErrorMessage = ccexpiryErrorMessage.getText();
		;
		if (creditcardExpiryErrorMessage.contains("Please Select your Credit Card Expiry Month")) {
			System.out.println("Credit Card Expiry is Mandatory");
		}
		Assert.assertTrue(ccexpiryErrorMessage.isDisplayed(), "User should enter valid details to search hotel.");
		return this;
	}

	public BookHotelPage getCvvErrorMessage() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(cvvErrorMessage));
		String creditcardCvvErrorMessage = cvvErrorMessage.getText();
		;
		if (creditcardCvvErrorMessage.contains("Please Enter your Credit Card CVV Number")) {
			System.out.println("Credit Card Cvv is Mandatory");
		}
		Assert.assertTrue(cvvErrorMessage.isDisplayed(), "User should enter valid details to search hotel.");
		return this;
	}

	public BookHotelPage clickLogoutButton() {

		logoutButton.click();
		return this;
	}

	public static void waitForTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
