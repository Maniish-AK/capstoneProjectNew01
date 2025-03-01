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

public class SearchHotelPage extends ProjectSpecificationMethods {

	@FindBy(id = "location")
	WebElement locationDropDown;

	@FindBy(id = "hotels")
	WebElement hotelsDropDown;

	@FindBy(id = "room_type")
	WebElement roomtypeDropDown;

	@FindBy(id = "room_nos")
	WebElement roomnoDropDown;

	@FindBy(id = "datepick_in")
	WebElement dateCheckinField;

	@FindBy(id = "datepick_out")
	WebElement dateCheckoutField;

	@FindBy(id = "adult_room")
	WebElement adultsPerRoomDropDown;

	@FindBy(id = "child_room")
	WebElement childPerRoomDropDown;

	@FindBy(id = "Submit")
	WebElement submitButton;

	@FindBy(id = "Reset")
	WebElement resetButton;

	@FindBy(id = "username_show")
	WebElement welcomeMessage;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logoutButton;
	
	@FindBy(xpath = "//a[contains(text(),'Booked Itinerary')]")
	WebElement bookedItineraryButton;

	@FindBy(xpath = "//span[@id='location_span']")
	WebElement locationErrorMessage;

	@FindBy(xpath = "//span[@id='checkin_span']")
	WebElement checkinDateErrorMessage;

	@FindBy(xpath = "//span[@id='checkout_span']")
	WebElement checkoutDateErrorMessage;

	public SearchHotelPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	public SearchHotelPage validateLogin() {
//
//		String currentUrl = driver.getCurrentUrl();
//		Assert.assertTrue(currentUrl.contains("/SearchHotel"), "User not logged in successfully.");
//		@SuppressWarnings("deprecation")
//		String loginMessage = welcomeMessage.getAttribute("value");
//		Assert.assertTrue(loginMessage.contains("Hello"), "User not logged in successfully.");
//		return this;
//	}

	public SearchHotelPage enterLocation(String location) {
		locationDropDown.click();
		waitForTime(1000);
		List<WebElement> myLocationElements = driver.findElements(By.xpath("//select[@id='location']//option"));
		for (int index = 0; index < myLocationElements.size(); index++) {
			if (myLocationElements.get(index).getText().equalsIgnoreCase(location)) {
				myLocationElements.get(index).click();
				break;
			}
		}
		return this;
	}

	public SearchHotelPage enterHotels(String hotels) {
		hotelsDropDown.click();
		waitForTime(1000);
		List<WebElement> myHotelsElements = driver.findElements(By.xpath("//select[@id='hotels']//option"));
		for (int index = 0; index < myHotelsElements.size(); index++) {
			if (myHotelsElements.get(index).getText().equalsIgnoreCase(hotels)) {
				myHotelsElements.get(index).click();
				break;
			}
		}
		return this;
	}

	public SearchHotelPage enterRoomType(String roomtype) {
		roomtypeDropDown.click();
		waitForTime(1000);
		List<WebElement> myRoomTypeElements = driver.findElements(By.xpath("//select[@id='room_type']//option"));
		for (int index = 0; index < myRoomTypeElements.size(); index++) {
			if (myRoomTypeElements.get(index).getText().equalsIgnoreCase(roomtype)) {
				myRoomTypeElements.get(index).click();
				break;
			}
		}
		return this;
	}

	public SearchHotelPage enterNoofRooms(String noofrooms) {
		roomnoDropDown.click();
		waitForTime(1000);
		List<WebElement> myNoofRoomsElements = driver.findElements(By.xpath("//select[@id='room_nos']//option"));
		for (int index = 0; index < myNoofRoomsElements.size(); index++) {
			if (myNoofRoomsElements.get(index).getText().equalsIgnoreCase(noofrooms)) {
				myNoofRoomsElements.get(index).click();
				break;
			}
		}
		return this;
	}

	public SearchHotelPage enterCheckInDate(String checkindate) {

		dateCheckinField.sendKeys(checkindate);
		return this;
	}

	public SearchHotelPage enterCheckOutDate(String checkoutdate) {

		dateCheckoutField.sendKeys(checkoutdate);
		return this;
	}

	public SearchHotelPage enterAdultPerRoom(String adultperroom) {
		adultsPerRoomDropDown.click();
		waitForTime(1000);
		List<WebElement> myAdultPerRoomElements = driver.findElements(By.xpath("//select[@id='adult_room']//option"));
		for (int index = 0; index < myAdultPerRoomElements.size(); index++) {
			if (myAdultPerRoomElements.get(index).getText().equalsIgnoreCase(adultperroom)) {
				myAdultPerRoomElements.get(index).click();
				break;
			}
		}
		return this;
	}

	public SearchHotelPage enterChildPerRoom(String childperroom) {
		childPerRoomDropDown.click();
		waitForTime(1000);
		List<WebElement> myChildPerRoomElements = driver.findElements(By.xpath("//select[@id='child_room']//option"));
		for (int index = 0; index < myChildPerRoomElements.size(); index++) {
			if (myChildPerRoomElements.get(index).getText().equalsIgnoreCase(childperroom)) {
				myChildPerRoomElements.get(index).click();
				break;
			}
		}
		return this;
	}

	public static void waitForTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public SelectHotelPage clickSearchButton() {

		submitButton.click();
		return new SelectHotelPage(driver);
	}

	public SearchHotelPage clickSearchButtonForInvalid() {

		submitButton.click();
		return this;
	}

	public SearchHotelPage clickResetButton() {

		resetButton.click();
		return this;
	}

	public SearchHotelPage getLocationErrorMessage() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(locationErrorMessage));
		String locErrorMessage = locationErrorMessage.getText();
		;
		if (locErrorMessage.contains("Please Select a Location")) {
			System.out.println("Location is Mandatory");
		}
		Assert.assertTrue(locationErrorMessage.isDisplayed(), "User should enter valid details to search hotel.");
		return this;
	}

	public SearchHotelPage getCheckinErrorMessage() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(checkinDateErrorMessage));
		String checkinErrorMessage = checkinDateErrorMessage.getText();
		;
		if (checkinErrorMessage.contains("Please Select Check-In Date")) {
			System.out.println("CheckIn date is Mandatory");
		}
		Assert.assertTrue(checkinDateErrorMessage.isDisplayed(), "User should enter valid details to search hotel.");
		return this;
	}

	public SearchHotelPage getCheckoutErrorMessage() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(checkoutDateErrorMessage));
		String checkoutErrorMessage = checkoutDateErrorMessage.getText();
		;
		if (checkoutErrorMessage.contains("Please Select Check-Out Date")) {
			System.out.println("CheckOut date is Mandatory");
		}
		Assert.assertTrue(checkoutDateErrorMessage.isDisplayed(), "User should enter valid details to search hotel.");
		return this;
	}
	
	public BookedItineraryPage clickBookedItineraryButton() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(bookedItineraryButton));
		bookedItineraryButton.click();
		return new BookedItineraryPage(driver);
	}
	
	public LogoutPage clickLogoutButton() {

		logoutButton.click();
		return new LogoutPage(driver);
	}

}
