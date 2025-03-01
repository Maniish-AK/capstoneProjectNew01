package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class BookConfirmPage extends ProjectSpecificationMethods {

	@FindBy (id = "search_hotel")
	WebElement searchHotelButton;
	
	@FindBy (id = "my_itinerary")
	WebElement myItineraryButton;
	
	@FindBy (id = "logout")
	WebElement logoutButton;
	
	@FindBy (id = "hotel_name")
	WebElement hotelNameField;
	
	@FindBy (id = "location")
	WebElement locationField;
	
	@FindBy (id = "room_type")
	WebElement roomtypeField;
	
	@FindBy (id = "arrival_date")
	WebElement arrivalDateField;
	
	@FindBy (id = "departure_text")
	WebElement departureDateField;
	
	@FindBy (id = "total_rooms")
	WebElement totalRoomsField;
	
	@FindBy (id = "adults_room")
	WebElement adultsRoomField;
	
	@FindBy (id = "children_room")
	WebElement childrenRoomField;
	
	@FindBy (id = "price_night")
	WebElement pricePerNightField;
	
	@FindBy (id = "total_price")
	WebElement totalPriceField;
	
	@FindBy (id = "gst")
	WebElement gstField;
	
	@FindBy (id = "final_price")
	WebElement finalPriceField;
	
	@FindBy (id = "first_name")
	WebElement firstNameField;
	
	@FindBy (id = "last_name")
	WebElement lastNameField;
	
	@FindBy (id = "address")
	WebElement addressField;
	
	@FindBy (id = "order_no")
	WebElement orderNoField;
	
	public BookConfirmPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public BookConfirmPage validateBookConfirm() {

		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("/BookingConfirm")) {
			Assert.assertTrue(currentUrl.contains("/BookingConfirm"), "User not logged in successfully.");
		}
		return this;
	}
	
	@SuppressWarnings("deprecation")
	public BookConfirmPage getBookingConfirmation() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(hotelNameField));
		String hotelName = hotelNameField.getAttribute("value");
		System.out.println("Hotel Name :: "+hotelName);
		String location = locationField.getAttribute("value");
		System.out.println("Location :: "+location);
		String roomType = roomtypeField.getAttribute("value");
		System.out.println("Room Type :: "+roomType);
		String arrivalDate = arrivalDateField.getAttribute("value");
		System.out.println("Arrival Date :: "+arrivalDate);
		String departureDate = departureDateField.getAttribute("value");
		System.out.println("Departure Date :: "+departureDate);
		String totalRooms = totalRoomsField.getAttribute("value");
		System.out.println("Totel Room :: "+totalRooms);
		String adultsPerRoom = adultsRoomField.getAttribute("value");
		System.out.println("Adults Per Room :: "+adultsPerRoom);
		String childPerRoom = childrenRoomField.getAttribute("value");
		System.out.println("Children Per Room :: "+childPerRoom);
		String pricePerNight = pricePerNightField.getAttribute("value");
		System.out.println("Price Per Night :: "+pricePerNight);
		String totalPrice = totalPriceField.getAttribute("value");
		System.out.println("Total Price :: "+totalPrice);
		String gst = gstField.getAttribute("value");
		System.out.println("GST :: "+gst);
		String finalPrice = finalPriceField.getAttribute("value");
		System.out.println("Final Billed Price :: "+finalPrice);
		String firstName = firstNameField.getAttribute("value");
		System.out.println("First Name :: "+firstName);
		String lastName = lastNameField.getAttribute("value");
		System.out.println("Last Name :: "+lastName);
		String billingAddress = addressField.getAttribute("value");
		System.out.println("Billing Address :: "+billingAddress);
		String orderNo = orderNoField.getAttribute("value");
		System.out.println("Order No :: "+orderNo);
		return this;
    }
	
	public BookedItineraryPage clickMyItineraryButton() {
		
		myItineraryButton.isDisplayed();
		myItineraryButton.click();
		return new BookedItineraryPage(driver);
    }

}
