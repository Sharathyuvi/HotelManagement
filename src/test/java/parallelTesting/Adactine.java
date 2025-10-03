	package parallelTesting;

	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.*;
	
	
	// at the same time if you want to work with two or more application you can go with parallel testing
		// Also you can work with multiple functionalities in an application


	public class Adactine {
		
	// here we are creating two applications adactine and cyclos application

		
		public static WebDriver dr;
		Select ss;
		@BeforeTest
		public void openApplication() {
			dr = new ChromeDriver();
			dr.get("https://adactinhotelapp.com/");
//			dr.manage().window().maximize();
			dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}
		
		@Test(priority=1)
		public void login() throws InterruptedException {
			dr.findElement(By.id("username")).sendKeys("Sharath23");
			dr.findElement(By.id("password")).sendKeys("Sharath@23");
			dr.findElement(By.id("login")).click();
			Thread.sleep(3000);
		}
		
		@Test(priority=2)
		public void searchHotel() {
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
		
		@AfterTest
		public void closeApplication() {
			dr.quit();
		}

	}
