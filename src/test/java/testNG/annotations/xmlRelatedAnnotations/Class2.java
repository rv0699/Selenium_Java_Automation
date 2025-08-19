package testNG.annotations.xmlRelatedAnnotations;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Class2 {
	
	/*
	 * Scope of BeforeTest and AfterTest is xml file level , however it will be executed only for those
	 * <test> tags in which the present class files have this method.
	 * 
	 * 
	 */
			
	
	@BeforeTest
	void bt() {
		System.out.println("Before test");
	}
	
	@Test
	void c2m1() {
		System.out.println("Class 2 Test method 1");
	}
	
	@Test
	void c2m2() {
		System.out.println("Class 2 Test method 2");
	}
	
	@AfterTest
	void at() {
		System.out.println("After test");
	}
	
	
}
