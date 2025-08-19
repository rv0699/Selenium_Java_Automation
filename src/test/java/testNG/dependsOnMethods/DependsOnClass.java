package testNG.dependsOnMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnClass {
	
	/*
	 * Consider the following scenario :
	 * 
	 * testMethod1 -> opening the application
	 * testMethod2 -> login
	 * testMethod3 -> perform search
	 * testMethod4 -> perform advanced search
	 * testMethod5 -> logout
	 * 
	 * In case testMethod1 fails , login along with other test methods should be skipped as the application
	 * itself did not open up , hence to achieve this , we can create dependency methods , which will make
	 * the dependent methods skip if the mentioned method fails
	 */
	
	@Test
	void testMethod1() {
		System.out.println("test method 1");
//		Assert.assertTrue(false);		// If this is kept , all dependent methods would be skipped
		Assert.assertFalse(false); 		// If this is kept , all dependent methods would be executed as assertion passes
	}
	
	/*
	 * Opening the application failed , hence all methods following it should be skipped as they will
	 * definitely fail as well.
	 * 
	 * Using dependOnMethods and mentioning the method on which execution of the method being executed depends
	 * on , method execution will be skipped.
	 */
	
	@Test(dependsOnMethods="testMethod1")
	void testMethod2() {
		System.out.println("test method 2");
	}

	@Test(dependsOnMethods="testMethod2")
	void testMethod3() {
		System.out.println("test method 3");
		Assert.assertTrue(false);
	}

	@Test(dependsOnMethods="testMethod3")
	void testMethod4() {
		System.out.println("test method 4");
	}

	@Test(dependsOnMethods="testMethod4")
	void testMethod5() {
		System.out.println("test method 5");
	}
	
	/*
	 * Using above approach , if Method1 fails , all following dependent methods will be skipped
	 */

	/*
	 * This can be followed down in the hierarchy as well , for eg - If a dependency is created between 
	 * method 3 and method 4 , and we pass that method4 is dependent on method 3 , then even if method 
	 * 1 and method 2 get executed successfully and method 3 fails , then method 4 and 5 will be skipped.
	 */
}
