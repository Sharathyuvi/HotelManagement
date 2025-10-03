package dependsOnMethod;

import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.*;

	
	// Depends of Method- Depends on previous method created 
	
	/* 1) Login
	   2) search hotel 
	   3) select hotel */
	public class DependsOnMethod {
		
		Select ss;
		public static WebDriver driver;
		@BeforeSuite
		public void openApplication() {
			driver = new ChromeDriver();
			driver.get("https://adactinhotelapp.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		@Test
		public void login() throws InterruptedException {
			driver.findElement(By.id("username")).sendKeys("Sharath23");
			driver.findElement(By.id("password")).sendKeys("Sharath@12");
			driver.findElement(By.id("login")).click();
			Thread.sleep(3000);
		}
		
		@Test(dependsOnMethods= {"login"})
		public void searchHotel() throws InterruptedException {
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
			Thread.sleep(3000);
			
		}
		
		@Test(dependsOnMethods= {"searchHotel"})
		public void selectHotel() throws InterruptedException {
			driver.findElement(By.id("radiobutton_2")).click();
			driver.findElement(By.id("continue")).click();
			Thread.sleep(3000);
			
			driver.close();
		}
		}
	
	

