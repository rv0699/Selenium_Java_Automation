package testNG.groups;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Class2 {
	@Test(groups="regression")
	void method1() {
		System.out.println("regression method");
	}
	
	@Test(groups="regression")
	void method2() {
		System.out.println("regression method");
	}
	
	@Test(groups="regression")
	void method3() {
		System.out.println("regression method");
	}
}
