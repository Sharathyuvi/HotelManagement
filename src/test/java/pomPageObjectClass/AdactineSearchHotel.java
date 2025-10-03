package pomPageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdactineSearchHotel {
	
//	1.constructor	2.identify the element	    3.create a actions
	public WebDriver driver;
	Select sc;
	public AdactineSearchHotel(WebDriver driver) // constructor is created
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="location")
	WebElement drpLocation;
	
	@FindBy(id="room_nos")
	WebElement drpNoOfRooms;
	
	@FindBy(xpath="//*[@id='datepick_in']")
	WebElement checkindate;
	
	@FindBy(xpath="//*[@id='datepick_out']")
	WebElement checkOutDate;
	
	@FindBy(id="adult_room")
	WebElement AdultPerRoom;
	
	@FindBy(id="Submit")
	WebElement btnsearch;
	
	
	public void setLocation() {
		sc = new Select(drpLocation);
		sc.selectByIndex(3);
	}
	
	public void setNoOfRooms() {
		sc = new Select(drpNoOfRooms);
		sc.selectByIndex(2);
	}
	
	public void checkindate() {
		checkindate.sendKeys("17/09/2025");
	}
	
	public void checkoutdate() {
		checkOutDate.sendKeys("17/09/2025");
	}
	
	public void setAdultperroom() {
		sc = new Select(AdultPerRoom);
		sc.selectByIndex(4);
	}
	
	public void btnsearch() throws InterruptedException {
		btnsearch.click();
	}
	}
