package assertions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class SoftAssertions {

	
	// Assertions- In TestNG, assertions are used to verify actual results against expected results during test execution. They help determine whether a test has passed or failed.
   // There are two types of Assertions 
   //  Hard Assertion, Soft Assertion 
	
	/* 1. Hard Assertions (Assert class)
	 If a hard assertion fails, the test method stops executing immediately.
	 Any remaining code in that test method will not run    */
	
public static WebDriver dr;

	Select ss;
@BeforeSuite
	public void openApplication() throws InterruptedException
	{
		dr=new ChromeDriver(); 
		dr.get("https://adactinhotelapp.com/");
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		dr.manage().window().maximize();
		
		Thread.sleep(3000);
	}
	@Test(priority=1)
	public void login() throws InterruptedException
	{
		dr.findElement(By.id("username")).sendKeys("Sharath23");
		dr.findElement(By.id("password")).sendKeys("Sharath@23");
		dr.findElement(By.id("login")).click();
		Thread.sleep(3000);
	}
	@Test(priority=2)
	public void verifyTheSearchHotel() throws InterruptedException
	{
		 String exp_Title = "Adactin.com - Search Hotel12"; //invalid 
		//String exp_Title = "Adactin.com - Search Hotel";	//valid
		String Act_Title = dr.getTitle();  // browser command
		
		SoftAssert sa= new SoftAssert(); // initilize SoftAssert and create an object
	
		if(exp_Title.equals(Act_Title)) {
			sa.assertTrue(true);
			System.out.println("TestCases is passed");
			Thread.sleep(3000);
		}
		else {
			sa.assertTrue(false);
			System.out.println("Testcaes is failed");
			Thread.sleep(3000);
		}

		WebElement location = dr.findElement(By.id("location"));

		ss = new Select(location);
		ss.selectByIndex(2);

		WebElement hotels = dr.findElement(By.id("hotels"));
		ss = new Select(hotels);
		ss.selectByVisibleText("Hotel Sunshine");

		WebElement numOfRooms = dr.findElement(By.id("room_nos"));
		ss = new Select(numOfRooms);
		ss.selectByValue("5");

		WebElement CheckIn = dr.findElement(By.id("datepick_in"));
		CheckIn.sendKeys("12/09/2025");

		WebElement CheckOut = dr.findElement(By.id("datepick_out"));
		CheckOut.sendKeys("16/09/2025");

		WebElement Adultperroom = dr.findElement(By.id("adult_room"));
		ss = new Select(Adultperroom);
		ss.selectByIndex(2);

		dr.findElement(By.id("Submit")).click();
}
	
	@Test(priority=3)
	public void selectHotel() throws InterruptedException {
		dr.findElement(By.id("radiobutton_2")).click();
		dr.findElement(By.id("continue")).click();
		
		Thread.sleep(3000);
	}
	
	@AfterSuite
	public void closeApplication() {
		dr.quit();
	}

}