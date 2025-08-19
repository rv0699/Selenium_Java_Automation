package testNG.groups;

import org.testng.annotations.Test;

public class Class3 {
	@Test(groups={"regression","sanity","functional"})
	void method1() {
		System.out.println("regression + sanity method");
	}
	
	@Test(groups={"regression","sanity","functional"})
	void method2() {
		System.out.println("regression + sanity method");
	}
	
	@Test(groups={"regression","sanity","functional"})
	void method3() {
		System.out.println("regression + sanity method");
	}
}
