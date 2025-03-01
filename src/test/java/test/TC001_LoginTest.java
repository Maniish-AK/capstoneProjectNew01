package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC001_LoginTest extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void setup() {
		sheetName="Login";
		
	}
	
//	@Test(priority=1, dataProvider = "excelRead")
//	public void loginTestWithInvalidCreds(String username, String password) {
//		
//		HomePage hp = new HomePage(driver);
//		hp.enterInvalidUsername()
//		.enterPassword(password)
//		.clickLoginButtonForInvalid()
//		.getLoginErrorMessage();
//	}
	
	@Test(dataProvider = "excelRead")
	public void loginTest(String username, String password, String type, String expected) {
		
		HomePage hp = new HomePage(driver);
		hp.enterUsername(username)
		.enterPassword(password)
		.clickLoginButton()
		.validateLogin(type, expected);
	}

}
