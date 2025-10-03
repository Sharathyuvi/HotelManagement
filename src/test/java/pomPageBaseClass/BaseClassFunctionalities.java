package pomPageBaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;

public class BaseClassFunctionalities {
//	 in this class we implement the common functionality of every tc (open application,close application)
	public static WebDriver driver;
	@BeforeClass
	@Parameters({"browser","url"})
	public void OpenApplication(String br, String URL) {
		if(br.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@AfterClass
	public void closeapplication() {
		driver.close();
	}
}
