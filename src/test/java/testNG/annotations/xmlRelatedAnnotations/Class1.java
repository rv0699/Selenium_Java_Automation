package testNG.annotations.xmlRelatedAnnotations;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Class1 {
	
	/*
	 * Scope of BeforeSuite is xml file level
	 * For eg -> if a suite is executed , this will be executed before any other method is
	 * executed 
	 * 
	 * 
	 * However , scope of BeforeMethod , AfterMethod is restricted to the class they are present
	 * in , so in this class , for both the methods present with Test annotation , BeforeMethod
	 * and AfterMethod will be executed BUT ONLY FOR THE TEST METHODS OF THIS CLASS.
	 */
	
	@BeforeSuite
	void bs() {
		System.out.println("Method executed Before Suite");
	}
	
	@Test
	void c1m1() {
		System.out.println("Class 1 Test method 1");
	}
	
	@Test
	void c1m2() {
		System.out.println("Class 1 Test method 2");
	}
	
	@BeforeMethod
	public void bm() {
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void am() {
		System.out.println("After Method");
	}
	
	@AfterTest
	void at() {
		System.out.println("After test");
	}
	
	
	@BeforeTest
	void bt() {
		System.out.println("Before test");
	}

}
