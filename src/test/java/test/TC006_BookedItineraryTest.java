package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC006_BookedItineraryTest extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void setup() {
		sheetName="BookItinerary";
		
	}
	
	@Test(priority=1, dataProvider = "excelRead")
	public void searchOrderIdAndShowall(String username, String password, String type, String expected, String location, String hotels, String roomtype, String noofrooms, String checkindate, String checkoutdate, String adultperroom, String childperroom,
			String firstname, String lastname, String address, String ccno, String cctype, String ccexpmonth, String ccexpyear, String cvv) {
		
		HomePage hp = new HomePage(driver);
		hp.enterUsername(username)
		.enterPassword(password)
		.clickLoginButton()
		.validateLogin(type, expected)
		.enterLocation(location)
		.enterHotels(hotels)
		.enterRoomType(roomtype)
		.enterNoofRooms(noofrooms)
		.enterCheckInDate(checkindate)
		.enterCheckOutDate(checkoutdate)
		.enterAdultPerRoom(adultperroom)
		.enterChildPerRoom(childperroom)
		.clickSearchButton()
		.validateHotelListDisplay()
		.clickSelectHotelRadioButton()
		.clickContinueButton()
		.enterFirstName(firstname)
		.enterLastName(lastname)
		.enterAddress(address)
		.enterCreditCardNo(ccno)
		.enterCreditcardType(cctype)
		.enterCreditcardExpMonth(ccexpmonth)
		.enterCreditcardExpYear(ccexpyear)
		.enterCvvNo(cvv)
		.clickBookNowButton()
		.validateBookConfirm()
		.getBookingConfirmation()
		.clickMyItineraryButton()
		.enterOrderId()
		.clickSearchOrderButton()
		.validateSearchOrderId()
		.clickShowAllLink()
		.clickLogoutButton();
	}
	
	@Test(priority=2, dataProvider = "excelRead")
	public void cancelSelectedHotelUsingButton(String username, String password, String type, String expected, String location, String hotels, String roomtype, String noofrooms, String checkindate, String checkoutdate, String adultperroom, String childperroom,
			String firstname, String lastname, String address, String ccno, String cctype, String ccexpmonth, String ccexpyear, String cvv) {
		
		HomePage hp = new HomePage(driver);
		hp.enterUsername(username)
		.enterPassword(password)
		.clickLoginButton()
		.validateLogin(type, expected)
		.clickBookedItineraryButton()
		.clickSelectFirstOrderCheckbox()
		.clickCancelSelectedButton()
		.clickLogoutButton();
	}
	
	@Test(priority=3, dataProvider = "excelRead")
	public void cancelOrderUsingButtonInsideGrid(String username, String password, String type, String expected, String location, String hotels, String roomtype, String noofrooms, String checkindate, String checkoutdate, String adultperroom, String childperroom,
			String firstname, String lastname, String address, String ccno, String cctype, String ccexpmonth, String ccexpyear, String cvv) {
		
		HomePage hp = new HomePage(driver);
		hp.enterUsername(username)
		.enterPassword(password)
		.clickLoginButton()
		.validateLogin(type, expected)
		.clickBookedItineraryButton()
		.clickFirstCancelButton()
		.clickLogoutButton();
	}

}
