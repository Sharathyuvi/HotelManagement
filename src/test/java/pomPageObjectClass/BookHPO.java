package pomPageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BookHPO {

	public WebDriver driver;  // remote driver, access multiple classes
	Select se;
	// 1. Constructor
	public BookHPO(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	// 2. Identify elements

	@FindBy(xpath="//input[@id='first_name']") 
	WebElement Firstname;
	@FindBy(id="last_name") 
	WebElement Lastname;
	@FindBy(id="address")
	WebElement Billingaddress;
	@FindBy(id="cc_num") 	
	WebElement CreditcardNo;
	@FindBy(id="cc_type") 
	WebElement CreditCrdType;
	@FindBy(id="cc_exp_month") 
	WebElement ExpiryMonth;
	@FindBy(id="cc_exp_year") 
	WebElement ExpiryYear;
	@FindBy(id="cc_cvv") 
	WebElement Cvv;
	@FindBy(id="book_now") 
	WebElement BookNowbtn;

	public void txtFirstName()
	{
		Firstname.sendKeys("Sharath");
	}

	public void txtLastName()
	{
		Lastname.sendKeys("Narannagari");
	}

	public void Address()
	{
		Billingaddress.sendKeys("Flat no: 10, Hyd ");
	}


	public void Cardnum ()
	{
		CreditcardNo.sendKeys("3698521479632581");
	}

	public void CreditCrdType()
	{
		se=new Select(CreditCrdType);
		se.selectByIndex(1);
	}

	public void  cardexpmon()
	{
		se=new Select(ExpiryMonth);
		se.selectByIndex(5);
	}

	public void cardexpyear()
	{
		se=new Select(ExpiryYear);
		se.selectByIndex(17);
	}

	public void Cvvnum()
	{
		Cvv.sendKeys("321");
	}

	public void btnclick()
	{
		BookNowbtn.click();
	}

}
