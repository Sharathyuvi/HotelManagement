package grouping;

import org.testng.annotations.Test;

public class Group {
	
	
	// Groping- Grouping of test cases is possible
	
	/* login (Regression)
regression(Regression)
search(Regression & retesting)
select(Regression & retesting)
abs(Retesting)
bnv(Retesting)
book a hotel(smoke & sanity)
booking(sanity)
*/
	@Test(priority=1, groups= {"Regression"})
	public void login() {
		System.out.println("Login is done");
	}
	@Test(priority=2, groups= {"Regression, sanity"})
	public void registration() {
		System.out.println("registration is done");
	}
	@Test(priority=3, groups= {"Regression","Retesting"})
	public void search() {
		System.out.println("search is done");
	}
	@Test(priority=4, groups= {"Regression","Retesting"})
	public void select() {
		System.out.println("select is done");
	}
	
	@Test(priority=5, groups= {"Retesting"})
	public void abs() {
		System.out.println("abs is done");
	}
	
	@Test(priority=6, groups= {"Retesting"})
	public void bnv() {
		System.out.println("bnv is done");
	}
	
	@Test(priority=7, groups= {"smoke","sanity"})
	public void book_a_hotel() {
		System.out.println("B_A_hotel is done");
	}
	@Test(priority=8,groups= {"sanity"})
	public void booking() {
		System.out.println("booking is done");
	}

}