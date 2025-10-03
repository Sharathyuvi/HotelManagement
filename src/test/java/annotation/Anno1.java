package annotation;
import org.testng.annotations.*;


 
 // 1. working with Method annotation 

// First BeforeMethod executes, Test executes and runs 1st test, AfterMethod executes again BeforeMethod, test executes and runs 2nd test, logout executes so..on..
// summary login, test1, logout, login test2, logout 
public class Anno1 
  {
	@BeforeMethod
	public void login()
    {
		System.out.println("Login successful");
    }
	
	@Test
	public void search() // ----> test 1
	{
	System.out.println("Search completed");
	}
	
	@AfterMethod
	public void logut()
	{
		System.out.println("Logout sucessfully");
	}
	
	@Test
	public void select() // ---> test 2
	{
	System.out.println("Select completed");
	}
}    


/*
// working with Class annotation
 // First BeforeClass executes, Test executes and runs all tests present, AfterMethod executes
 // summary login, test 1, test 2 ---- (n)tests executes and logout
public class Anno 
{
@BeforeClass
public void login()
    {
	System.out.println("Login successfull");
    }

@Test
public void search()
    {
	System.out.println("Search completed");  // ---> test 1
    }

@AfterClass
public void logout() 
    {
	System.out.println("Logout successfull");
    }

@Test
public void select()   // ---> test 2
    {
	System.out.println("Select successfull");
    }
}

*/


/*
-------------------------------------------------------
// Test Annotation is similar to Class anotation 
// When working with single class we use Class annotation
// When working with multiple classes we use Test annotation
----------------------------------------------------

// Suite Annotation is similar to Class anotation 
// difference is 
// ends with suite level, here logout is done at suite level (ie) ends at suite level

 */

