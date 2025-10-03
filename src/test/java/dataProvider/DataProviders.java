package dataProvider;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

// DataProvider- In TestNG, a DataProvider is used to supply multiple sets of data to a single test method.
// It helps in Data-Driven Testing (running the same test with different inputs).

public class DataProviders {
	public static WebDriver driver;
	@BeforeSuite
	@Parameters({"browser","url"})
	public void openApplication(String br,String URL) {
		if(br.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(br.equals("Firefox")){
			driver = new FirefoxDriver();
		}
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(dataProvider="data")  // here dataProvider is parameter,  Redirecting to dataprovider name called data 
	public void login(String user, String password) throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login")).click();
		Thread.sleep(3000);
		
	}
	
	
	@org.testng.annotations.DataProvider(name="data", indices= {0,1,2,3,4}) // DataProvider is the annotation here 
	String [][] logindata(){
	String	data[][] = {
				{"sharath","sht"},
				{"Sharath23","sht"},
				{"Sharath",""},
				{"Sharath23","asd "},
				{"Sharath23","Sharath@23"}
		};
	
	return data;
	
	}
	
}

	
	
	
	

