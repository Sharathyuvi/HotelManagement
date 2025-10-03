package pomPageTestcases;

import org.testng.annotations.Test;

import pomPageBaseClass.BaseClassFunctionalities;
import pomPageObjectClass.AdactineLogin;

public class LoginTestCases extends BaseClassFunctionalities  // Inheritence baseclass has been called 
{
	
	public AdactineLogin Al;   // page obj class has been called 
	@Test
	public void login() throws InterruptedException {
		Al = new AdactineLogin(driver);
		Al.setusernmae();
		Al.setpassword();
		Al.clicklogin();
		
		Thread.sleep(3000);
	}

}
