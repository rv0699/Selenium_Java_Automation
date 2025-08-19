package testNG.annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 * Test Scenario 2
 * 
 * Login		@BeforeClass
 * Search 1		@Test
 * Search 2		@Test
 * Logout		@AfterClass
 * 
 * 
 */

public class Annotations2 {
	
	@BeforeClass
	public void bc() {
		System.out.println("Inside login - @BeforeClass");
	}
	
	@Test
	public void tc2_search1() {
		System.out.println("Inside search test 1 - @Test");
	}
	
	@Test
	public void tc2_search2() {
		System.out.println("Inside search test 2 - @Test");
	}
	
	@AfterClass
	public void ac() {
		System.out.println("Inside logout - @AfterClass");
	}
	
}

/*
Console output :

Inside login - @BeforeClass
Inside search test 1 - @Test
Inside search test 2 - @Test
Inside logout - @AfterClass
*/