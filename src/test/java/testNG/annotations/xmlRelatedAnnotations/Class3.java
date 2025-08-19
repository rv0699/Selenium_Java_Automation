package testNG.annotations.xmlRelatedAnnotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Class3 {
	
	/*
	 * AfterSuite method will be executed at the end when execution of all methods is completed
	 * IN OTEHR WORDS , WHEN SUITE EXECUTION IS COMPLETED
	 * 
	 * 
	 * BeforeClass and AfterClass methods are also specific to the class file in which they are 
	 * present , so if they are present only in Class3.java , they will be executed before and after 
	 * this class
	 * 
	 * 
	 */
	
	@Test
	void c3m1() {
		System.out.println("Class 3 Test method 1");
	}
	
	@Test
	void c3m2() {
		System.out.println("Class 3 Test method 2");
	}
	
	@AfterSuite
	void bs() {
		System.out.println("Method executed After Suite");
	}
	
	@BeforeClass
	public void bc() {
		System.out.println("Before Class");
	}
	
	@AfterClass
	public void ac() {
		System.out.println("After Class");
	}
	
	
	
	
}
