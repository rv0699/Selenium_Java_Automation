package assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertions {
	

	/*
	 * Using soft assertions , statements after the assertions statement can be executed , irrespective of the
	 * fact that assertion is failing or passing.
	 * 
	 * This can be done using SoftAssert class , by simply using object of this class instead of Assert class,
	 * we can achieve the above
	 * 
	 */

	
	@Test
	void softAssertions1() {
		
		/*
		 * This test case passes as assertion gets expected and Actual message as equal
		 * 
		 */
		String actualMessage = "This is example of hard assertion";
		String expectedMessage = "This is example of hard assertion";
		
		SoftAssert sa = new SoftAssert();
		
		sa.assertEquals(actualMessage, expectedMessage);
		
		System.out.println("Executed after assertion");
		System.out.println("Executed after assertion 1");
	}
	
	
	/*
	 * However , in soft assertions , there lies a problem , even though the assertions pass or fail , test
	 * methods will always show as PASSED , consider below example.
	 * 
	 */
	
	@Test
	void softAssertions2() {
		
		/*
		 * This test case passes as assertion gets expected and Actual message as equal
		 * 
		 */
		String actualMessage = "This is example of hard assertion";
		String expectedMessage = "This is example of soft assertion";
		
		SoftAssert sa = new SoftAssert();
		
		sa.assertEquals(actualMessage, expectedMessage);	// Assertion fails here
		
		System.out.println("Executed after assertion");
		System.out.println("Executed after assertion 1");
		
		/*
		 * In order for assertions to work correctly , following statement need to be used whenever soft assertions
		 * are being used :
		 * 		sa.assertAll();
		 */
		
		sa.assertAll();
	}

}
