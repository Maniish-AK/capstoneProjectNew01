package pages;

import java.time.Duration;
import java.util.ArrayList;
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

public class BookedItineraryPage extends ProjectSpecificationMethods {

	private int initialCount;
	
	@FindBy (id = "order_id_text")
	WebElement searchOrderField;
	
	@FindBy (id = "search_hotel_id")
	WebElement searchOrderButton;
	
	@FindBy (xpath = "//input[@value='Cancel Selected']")
	WebElement cancelSelectedButton;
	
	@FindBy (id = "search_hotel")
	WebElement searchHotelButton;
	
	@FindBy (id = "logout")
	WebElement logoutButton;
	
	@FindBy (xpath = "(//input[@name='ids[]'])[1]")
	WebElement selectFirstOrderCheckbox;
	
	@FindBy (xpath = "(//input[@type='button' and contains(@value, 'Cancel')])[1]")
	WebElement firstCancelButton;
	
	@FindBy (xpath = "(//input[@type='text' and contains(@name, 'order_id')])[2]")
	WebElement firstOrderId;
	
	@FindBy (xpath = "//input[@type='text' and contains(@name, 'order_id')]")
    List<WebElement> noofOrderids;
	
	@FindBy (xpath = "//label[@id='search_result_error']")
	WebElement searchResultMessage;
	
	@FindBy (xpath = "//a[contains(text(),'Show all')]")
	WebElement showAllLink;
	
	public BookedItineraryPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public BookedItineraryPage enterOrderId() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfAllElements(noofOrderids));
	    wait.until(ExpectedConditions.visibilityOf(firstOrderId));
	    @SuppressWarnings("deprecation")
		String firstHotelOrderId = firstOrderId.getAttribute("value");
	    wait.until(ExpectedConditions.visibilityOf(searchOrderField));
		searchOrderField.sendKeys(firstHotelOrderId);
		return this;
    }
	
	public BookedItineraryPage clickSearchOrderButton() {
		
		searchOrderButton.click();
		return this;
    }
	
    public BookedItineraryPage validateSearchOrderId() {
		
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOfAllElements(searchResultMessage));
        String resultCount = searchResultMessage.getText();
        Assert.assertTrue(resultCount.contains("1 result(s) found."), "Search Order failed!");
		return this;
    }
    
    public BookedItineraryPage clickShowAllLink() {
		
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOfAllElements(showAllLink));
    	showAllLink.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(noofOrderids));
        Assert.assertTrue(noofOrderids.size() > 1, "Show All failed!");
		return this;
    }
    
    public BookedItineraryPage clickSelectFirstOrderCheckbox() {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(noofOrderids));
        initialCount = noofOrderids.size();
        wait.until(ExpectedConditions.visibilityOf(selectFirstOrderCheckbox));
		selectFirstOrderCheckbox.click();
		return this;
    }
    
    public BookedItineraryPage clickCancelSelectedButton() {
		cancelSelectedButton.click();
		driver.switchTo().alert().accept();
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfAllElements(noofOrderids));
	    Assert.assertEquals(noofOrderids.size(), initialCount - 1, "Order cancelation failed!");
	    return this;
    }
	
	public void clickLogoutButton() {
		
		logoutButton.click();
		
    }
	
	public BookedItineraryPage clickFirstCancelButton() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfAllElements(noofOrderids));
	    wait.until(ExpectedConditions.visibilityOf(firstCancelButton));
		firstCancelButton.click();
		driver.switchTo().alert().accept();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String resultCount = searchResultMessage.getText();
	    Assert.assertTrue(resultCount.contains("The booking has been cancelled."), "Cancel Order using Cancel button in table failed!");
	    return this;
    }
	
	public List<String> getAllOrderIds() {
        List<String> orderIds = new ArrayList<>();
        for (WebElement row : noofOrderids) {
            WebElement nameElement = row.findElement(By.xpath(".//td[2]"));
          //table[@id='myTable']//tr//td[2]
//            contactNames.add(nameElement.getText());
            orderIds.add(nameElement.getText().trim());
        }
        return orderIds;
    }
	
	

}
