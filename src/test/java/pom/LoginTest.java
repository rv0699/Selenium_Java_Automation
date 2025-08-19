package pom;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver driver;
	
	@BeforeClass
	void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	void testLogin() {
		String username = "Admin";
		String password = "admin123";
		LoginPage2 loginScreen = new LoginPage2(driver);
		loginScreen.enterUsername(username);
		loginScreen.enterPassword(password);
		loginScreen.clickLoginBtn();
		
		//Assertion
		AssertJUnit.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	
	@AfterMethod
	@AfterClass
	void tearDown() {
		driver.quit();
	}
	

}