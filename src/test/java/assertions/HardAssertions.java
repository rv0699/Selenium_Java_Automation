package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {
	
	/*
	 * If else or switch statements can also be used for different consitions however , methods marked with
	 * @Test annotation will never be failed even though condition passed is not satisfied , hence Assertions
	 * are required so the test can fail when the required condition is not satisifed.
	 * 
	 */
	
	/*
	 * 
	 * Assertion should always be present at the end of the method with @Test annotation
	 * 
	 */
	
	/*
	 * The problem with Hard Assertions is that , any statement written after the assertion statement
	 * will not get executed if assertion is failing
	 * 
	 */
	
	@Test
	void testWithoutAssertions() {
		
		/*
		 * Here , test case should fail because a1 is not equal to a2 , but it will pass as the method
		 * is executed completely 
		 * 
		 * Execution of TestNG Test gives following output in console : 
		 * 
		 * Unequal , test case fail
		   PASSED: assertions.HardAssertions.testWithAssertions
		 * 
		 */
		
		int a1 = 1;
		int a2 = 2;
		
		if (a1 == a2) {
			System.out.println("Equal , test case pass");
		}
		
		else {
			System.out.println("Unequal , test case fail");
		}
		
	}
	
	@Test
	void testWithAssertionsPass() {
		
		/*
		 * This test case passes as assertion gets expected and Actual message as equal
		 * 
		 */
		String actualMessage = "This is example of hard assertion";
		String expectedMessage = "This is example of hard assertion";

		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	@Test
	void testWithAssertionsFail() {
		/*
		 * This test case fails as assertion gets expected and Actual message as unequal
		 * 
		 */
		
		String actualMessage = "This is example of hard assertion";
		String expectedMessage = "This is not an example of hard assertion";

		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	
	@Test
	void issueInHardAssertions() {
		
		String actualMessage = "This is example of hard assertion";
		String expectedMessage = "This is example of hard assertion";

		Assert.assertEquals(actualMessage, expectedMessage);
		
		//Following statement is not executed as the test method gets failed if assertion fails
		
		//If we want to execute statement after assertion irrespective of status of the status , 
		//we can use SoftAssert
		
		System.out.println("After assertion");
	}

}
