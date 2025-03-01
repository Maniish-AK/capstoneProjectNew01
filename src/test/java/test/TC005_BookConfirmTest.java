package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC005_BookConfirmTest extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void setup() {
		sheetName="BookItinerary";
		
	}
	
	@Test(dataProvider = "excelRead")
	public void bookConfirmHotel(String username, String password, String type, String expected, String location, String hotels, String roomtype, String noofrooms, String checkindate, String checkoutdate, String adultperroom, String childperroom,
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
		.clickMyItineraryButton();
	}

}
