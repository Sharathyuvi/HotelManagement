package annotation;



// Annotation- It helps to organise test cases better than plain method
import org.testng.annotations.*;

public class Anno {

	@BeforeSuite
	public void method1()
	{
		System.out.println("M1 is executed");
	}
	
	@BeforeMethod
	public void method2()
	{
		System.out.println("M2 is executed");
	}
	
	
	@BeforeClass
	public void method3()
	{
		System.out.println("M3 is executed");
	}
	
	@BeforeTest
	public void method4()
	{
		System.out.println("M4 is executed");
	}
	
	@AfterSuite
	public void method5()
	{
		System.out.println("M5 is executed");
	}
	
	@AfterMethod
	public void method6()
	{
		System.out.println("M6 is executed");
	}
	
	@AfterClass
	public void method7()
	{
		System.out.println("M7 is executed");
	}
	
	@AfterTest
	public void method8()
	{
		System.out.println("M8 is executed");
	}
	
	@Test
	public void method9()
	{
		System.out.println("M9 is executed");
	}
}
