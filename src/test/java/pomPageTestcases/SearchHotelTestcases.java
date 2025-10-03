package pomPageTestcases;

import org.testng.annotations.Test;

import pomPageObjectClass.AdactineSearchHotel;



public class SearchHotelTestcases extends LoginTestCases{
	
	public AdactineSearchHotel sh;
	@Test
	public void SearchHotel() throws InterruptedException {
		sh = new AdactineSearchHotel(driver);
		sh.setLocation();
		sh.setNoOfRooms();
		sh.checkindate();
		sh.checkoutdate();
		sh.setAdultperroom();
		sh.btnsearch();
		
		Thread.sleep(3000);
	}

}