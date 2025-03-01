package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC002_SearchHotelTest extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void setup() {
		sheetName="SearchHotel";
		
	}
	
	@Test(dataProvider = "excelRead")
	public void searchHotel(String username, String password, String type, String expected, String location, String hotels, String roomtype, String noofrooms, String checkindate, String checkoutdate, String adultperroom, String childperroom) {
		
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
		.clickSearchButton();
	}

}
