package prioritization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Prior {

	// Prioritization- Prioritization of test cases is possible
	
	public static WebDriver dr;
	@BeforeClass
 public void OpenApplication()
 
	{
		dr= new ChromeDriver();
		dr.get("http://adactinhotelapp.com/");
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		dr.manage().window().maximize();
	}
		
	@Test(priority=2)
		public void Login() throws InterruptedException
		{
		dr.findElement(By.id("username")).sendKeys("Sharath23");
		dr.findElement(By.id("password")).sendKeys("sgsdbx");
		dr.findElement(By.id("login")).click();
		Thread.sleep(3000);	
		dr.navigate().back();
	}
    @Test(priority=1)
	public void Registration() throws InterruptedException
	{
		dr.findElement(By.xpath("//a[text()='New User Register Here']")).click();
		dr.findElement(By.xpath("//input[@name='username']")).sendKeys("Sharath");
		dr.findElement(By.id("password")).sendKeys("abcdef@90");
		dr.findElement(By.xpath("//input[@name='re_password']")).sendKeys("ghijklmno@09");
		dr.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Sharath Reddy");
		dr.findElement(By.xpath("//input[@name='email_add']")).sendKeys("pqrstuvw@gmail.com");
		Thread.sleep(3000);
		dr.navigate().back();
		
	}
	@Test(priority=3)
	public void ForgotPassword() throws InterruptedException
	{
		dr.findElement(By.xpath("//a[text()='Forgot Password?']")).click();
		dr.findElement(By.xpath("//input[@name='emailadd_recovery']")).sendKeys("nmautgh@gmail.com");
		Thread.sleep(5000);
		dr.navigate().back();
		Thread.sleep(3000);
	}
	
	
	// if you dont @Test(Enabled=false) 
	
	@AfterClass
	public void CloseApplication()
	{
		dr.close();
	}
 
 
}
