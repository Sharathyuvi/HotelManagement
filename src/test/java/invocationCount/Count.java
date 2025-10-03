package invocationCount;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Count
{
  // If we want to iterate the data or want to work with multiple data we use invocation count	
	public static WebDriver driver;
	@BeforeClass
	public void openApplication() {
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@Test(invocationCount=3)
	public void LoginFunctionality() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("Sharath23");
		driver.findElement(By.id("password")).sendKeys("Sharath@23");
		driver.findElement(By.id("login")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		driver.findElement(By.xpath("//a[text()='Click here to login again']")).click();
		Thread.sleep(5000);
		driver.close();
		}
	
	}