package parallelTesting;

import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.*;

	public class CyclosApp {

		public static WebDriver dr;
		@BeforeTest
		public void openApplication() {
			dr = new FirefoxDriver();
			dr.get("https://demo.cyclos.org/ui/home");
			dr.manage().window().maximize();
			dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}
		
		@Test(priority=1)
		public void loginFunctionality() throws InterruptedException {
			dr.findElement(By.id("login-link")).click();
			
			dr.findElement(By.xpath("//*[@formcontrolname='principal']")).sendKeys("demo");
			dr.findElement(By.xpath("//*[@autocomplete='password']")).sendKeys("1234");
			dr.findElement(By.xpath("(//*[@type='button'])[2]")).click();
		Thread.sleep(6000);
		
		}
		
		@Test(priority=2)
		public void logout() throws InterruptedException {
			dr.findElement(By.id("logout-trigger")).click();
			Thread.sleep(6000);
		}
		
		@Test(priority=3)
		public void relogin() throws InterruptedException {
			dr.findElement(By.id("login-link")).click();
			
			dr.findElement(By.xpath("//*[@formcontrolname='principal']")).sendKeys("demo");
			dr.findElement(By.xpath("//*[@autocomplete='password']")).sendKeys("1234");
			dr.findElement(By.xpath("(//*[@type='button'])[2]")).click();
			Thread.sleep(6000);
		}	
		
		@AfterTest
		public void closeApplication() {
			dr.quit();
		}
		
	}

