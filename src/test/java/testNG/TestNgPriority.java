package testNG;

import org.testng.annotations.Test;

public class TestNgPriority {
	
	/*	
	 	By default , Test methods are executed in alphabetical order 
		i.e if no priority is given , methods will be executed as :
		
		setup
		tearDown
		test
	*/
	
	/*
	 	However , if some priority is given, test methods are executed 
	 	as per the given priority
	 */
	
	/*
	  	If nothing is given in priority parameter , by default the 
	  	priority is considered as 0
	*/
	 
	/*
	 	Negative numbers can also be given in priority 
	 */
	
	@Test(priority=1)
	void setup() {
		System.out.println("Inside setup method");
	}
	
	@Test(priority=2)
	void test1() {
		System.out.println("Inside test1 method");
	}
	
	@Test(priority=3)
	void teardown() {
		System.out.println("Inside teardown method");
	}
	
}
