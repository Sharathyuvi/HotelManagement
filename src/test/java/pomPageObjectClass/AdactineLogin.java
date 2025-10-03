package pomPageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactineLogin {

/*What is Page Object Model?
  It is a design pattern where each web page of the application is represented as a class in the code.
  The elements (locators) on that page are defined as variables.
  The actions/methods that can be performed on those elements are defined as methods in the class.
  
  Instead of writing locators and actions directly inside your test scripts, you put them inside Page classes and call those methods from your test cases   */

// Page object is divided into three types 
// 1)create Constructor
 
	public  WebDriver driver;  // remote driver, access multiple classes
    public AdactineLogin(WebDriver driver)     // constructor is created and local driver is created it can access single class
{
    	this.driver=driver;   // this is used to call the local instance
	     PageFactory.initElements(driver,this);   // you can identify webelement in the page 
}
    //  2. Identify the elements
    
    // WebElement txtUsername= driver.findelement(By.id("username"));  // general way to identify the webelement
	@FindBy(id="username") // while working with page factory you should find element this way
	WebElement txtUsername;
	
	@FindBy(id="password")
	WebElement txtpassword;
	
	@FindBy(id="login")
	WebElement btnLogin;
	
	//  3.  create an Actions
	
	public void setusernmae() {
		txtUsername.sendKeys("Sharath12");
	}
	
	public void setpassword() {
		txtpassword.sendKeys("G7XJ03");
	}
	
	public void clicklogin() {
		btnLogin.click();
	}
	
}

