package pomPageTestcases;

import org.testng.annotations.Test;


import pomPageObjectClass.BookingConfirm;

public class TC_ConfirmHotel extends TC_Book
{
	
	public BookingConfirm bc;
	@Test
	public void ConfirmHotel() throws InterruptedException  {
		bc = new BookingConfirm(driver);
		bc.butnLocation();
		
		
		Thread.sleep(3000);
	}
}
