package testNG.groups;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Class1 {
	@Test(groups="sanity")
	void method1() {
		System.out.println("sanity method");
	}
	
	@Test(groups="sanity")
	void method2() {
		System.out.println("sanity method");
	}
	
	@Test(groups="sanity")
	void method3() {
		System.out.println("sanity method");
	}
}
