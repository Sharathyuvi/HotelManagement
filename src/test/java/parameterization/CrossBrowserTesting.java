package parameterization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;

public class CrossBrowserTesting {
	
	
	//Parameterization-  Cross browser execution is possible 
	
	public static WebDriver dr;
	Select ss;
	@BeforeSuite
	@Parameters({"browser","url"})
	public void openApplication(String br,String URL) {
		if(br.equals("chrome")) {
			dr = new ChromeDriver();
		}
		else if(br.equals("Edge")) {
			dr = new EdgeDriver();
		}
		else if( br.equals("firefox")) {
			dr = new FirefoxDriver();
		}
		
		dr.get(URL);
		dr.manage().window().maximize();
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
	
	@AfterSuite
	public void closeApplication() {
		dr.quit();
	}

}