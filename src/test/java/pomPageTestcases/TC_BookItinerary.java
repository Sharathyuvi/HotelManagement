package pomPageTestcases;

import org.testng.annotations.Test;
import pomPageObjectClass.BookItinerary;

public class TC_BookItinerary extends TC_ConfirmHotel {

    public BookItinerary bi;

    @Test
    public void BookedItinerary() throws InterruptedException {
        // Initialize POM with driver from Base/Parent class
        bi = new BookItinerary(driver);

        Thread.sleep(3000);
    }
}