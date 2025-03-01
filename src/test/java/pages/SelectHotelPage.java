package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;

public class SelectHotelPage extends ProjectSpecificationMethods {

	@FindBy (id = "radiobutton_0")
	WebElement selectHotelRadiobutton;
	
	@FindBy (id = "continue")
	WebElement continueButton;
	
	@FindBy (id = "cancel")
	WebElement cancelButton;
	
	public SelectHotelPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public SelectHotelPage clickSelectHotelRadioButton() {
		
		try {
			selectHotelRadiobutton.isDisplayed();
			selectHotelRadiobutton.click();
		} catch (NoSuchElementException e) {
			System.out.println("User should enter valid details to search hotel.");
		}
		return this;
		
    }
	
	public BookHotelPage clickContinueButton() {
		
		try {
			continueButton.isDisplayed();
			continueButton.click();
		} catch (NoSuchElementException e) {
			System.out.println("User should enter valid details to search hotel.");
		}
		return new BookHotelPage(driver);
    }
	
	public SelectHotelPage validateHotelListDisplay() {
		
        selectHotelRadiobutton.isDisplayed();
        return this;
    }
	
	

}
