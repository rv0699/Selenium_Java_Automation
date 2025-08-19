package testNG.annotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * Test Scenario
 * 
 * login		@BeforeMethod
 * search 1		@Test
 * logout		@AfterMethod
 * login
 * search 2		@Test
 * logout
 */

public class Annotations1 {
	
	@BeforeMethod
	public void login() {
		System.out.println("Inside login - @BeforeMethod");
	}
	
	@Test
	public void search1() {
		System.out.println("Inside search test 1 - @Test");
	}
	
	@Test
	public void search2() {
		System.out.println("Inside search test 2 - @Test");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("Inside logout - @AfterMethod");
	}
	
}


/*
 * Console output : 
 * 
Inside login - @BeforeMethod
Inside search test 1 - @Test
Inside logout - @AfterMethod
Inside login - @BeforeMethod
Inside search test 2 - @Test
Inside logout - @AfterMethod
 * 
 */
