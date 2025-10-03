package pomPageTestcases;

import org.testng.annotations.Test;

import pomPageObjectClass.AdactineSelectHotel;

public class SelectHotelTestcases extends SearchHotelTestcases 
{
public AdactineSelectHotel sho;
	@Test
	public void SelectHotel() throws InterruptedException  {
		sho = new AdactineSelectHotel(driver);
		sho.btnLocation();
		sho.btnclick();
		
		Thread.sleep(3000);
	}
}
