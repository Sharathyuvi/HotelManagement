package pomPageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactineSelectHotel {

	// 1)create Constructor
	public WebDriver driver;  // remote driver, access multiple classes
	
    public AdactineSelectHotel(WebDriver driver)
    
    {
		this.driver=driver;
		PageFactory.initElements(driver, this);
}
	// 2.identify the element	
    
    
    @FindBy(id="radiobutton_4")
    WebElement btn;                     //
    
    @FindBy(id="continue")
    WebElement btncontinue;
    
    // 3. Create Actions
    
    public void btnLocation() {
		btn.click();
    }
    
    public void btnclick() {
		btncontinue.click();
   } 
}
