package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC007_LogoutTest extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void setup() {
		sheetName="Logout";
		
	}
	
	
	@Test(dataProvider = "excelRead")
	public void cancelOrderUsingButtonInsideGrid(String username, String password, String type, String expected) {
		
		HomePage hp = new HomePage(driver);
		hp.enterUsername(username)
		.enterPassword(password)
		.clickLoginButton()
		.validateLogin(type, expected)
		.clickLogoutButton()
		.validateLogout();
	}

}
