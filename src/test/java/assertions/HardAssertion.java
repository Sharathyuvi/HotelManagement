/*  2. Soft Assertions (SoftAssert class)
       Test continues execution even if an assertion fails.
       At the end, assertAll() must be called to report failures    */

package assertions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;


public class HardAssertion {
	
	public static WebDriver driver;
	Select ss;
	@BeforeSuite
	public void openApplication() {
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@Test(priority=1)
	public void login() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("Sharath23");
		driver.findElement(By.id("password")).sendKeys("Sharath@23");
		driver.findElement(By.id("login")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=2)
	public void searchHotel() {
		WebElement location = driver.findElement(By.id("location"));
		
		ss = new Select(location);
		ss.selectByIndex(2);
		
		WebElement hotels = driver.findElement(By.id("hotels"));
		ss = new Select(hotels);
		ss.selectByVisibleText("Hotel Sunshine");
		
		WebElement numOfRooms = driver.findElement(By.id("room_nos"));
		ss = new Select(numOfRooms);
		ss.selectByValue("5");
		
		WebElement CheckIn = driver.findElement(By.id("datepick_in"));
		CheckIn.sendKeys("12/09/2025");
		
		WebElement CheckOut = driver.findElement(By.id("datepick_out"));
		CheckOut.sendKeys("16/09/2025");
		
		WebElement Adultperroom = driver.findElement(By.id("adult_room"));
		ss = new Select(Adultperroom);
		ss.selectByIndex(2);
		
		driver.findElement(By.id("Submit")).click();
		
	}
	@Test(priority=3)
	public void verifySelectHotel() throws InterruptedException {
      
		String Exp_Titile = "Adactin.com - Select Hotel12";  // invalid
		String Act_Title = driver.getTitle();
		
		
		// for hard assertions you no needed to create any object
		
		if(Exp_Titile.equals(Act_Title)) {
			Assert.assertTrue(true);
			System.out.println("TC is passed");
		}
		else{
			System.out.println("Tc is failed");
			Assert.assertTrue(false);
			}
	Thread.sleep(3000);
		
		driver.findElement(By.id("radiobutton_2")).click();
		driver.findElement(By.id("continue")).click();
		
		
	
	}

}

