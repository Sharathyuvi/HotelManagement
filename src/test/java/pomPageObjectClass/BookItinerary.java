package pomPageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookItinerary {
	
	// 1)create Constructor
			public WebDriver driver;  // remote driver, access multiple classes
			
		    public BookItinerary(WebDriver driver)
		    {
		    	this.driver=driver;
				PageFactory.initElements(driver, this);
		    }
				// 2.identify the element	
			    
		 @FindBy(id="logout")
		 WebElement Logoutbtn;                     //
			    
			    // 3. Create Actions
			    
			    public void buttnLocation() {
			    	Logoutbtn.click();
			    }
		    }



