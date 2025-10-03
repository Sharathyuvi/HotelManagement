package pomPageTestcases;

import org.testng.annotations.Test;


import pomPageObjectClass.BookHPO;

public class TC_Book extends SelectHotelTestcases {
	public BookHPO bh;
	@Test
	public void BookHotel()   {
		bh = new BookHPO(driver);
		
		bh.txtFirstName();
		bh.txtLastName();
		bh.Address();
		bh.Cardnum();
		bh.CreditCrdType();
		bh.cardexpmon();
		bh.cardexpyear();
		bh.Cvvnum();
		bh.btnclick();
		
	}
}
