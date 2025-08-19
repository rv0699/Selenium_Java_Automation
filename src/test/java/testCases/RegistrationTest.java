package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

//import org.apache.commons.lang3.RandomStringUtils;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseTest;

public class RegistrationTest extends BaseTest{
	
//	String randomString() {
//		String generatedString = RandomStringUtils.randomAlphabetic(6);
//		return generatedString;
//	}
//	
//	String randomNumber() {
//		String generatedNumber = RandomStringUtils.randomNumeric(9);
//		return generatedNumber;
//	}
//	
//	String randomAlphaNum() {
//		String generatedAlphaNum = RandomStringUtils.randomAlphanumeric(7);
//		return generatedAlphaNum;
//	}
	
//	public WebDriver driver;
	
	/*
	 * Since setup() and tearDown() methods are common and will be used in each and every
	 * test case , we can include these methods in a common test class which can then be
	 * extended by other test classes
	 * 
	 * likewise for randomString , randomNumber , randomAlphaNum methods
	 */
	
//	@BeforeClass
//	void setup() {
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://tutorialsninja.com/demo/");
//		driver.manage().window().maximize();
//	}
//	
//	@AfterClass
//	void tearDown() {
//		driver.quit();
//	}
	
	@Test(groups={"Sanity","Master"})
	void registerationTest_TC001() {
		logger.info("Starting registerationTest_TC001");
		HomePage homeScreen = new HomePage(driver);
		logger.info("Clicking on My Account link");
		homeScreen.click_my_acc_link();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		logger.info("Clicking on Registration link");
		homeScreen.click_reg_link();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		RegistrationPage regScreen = new RegistrationPage(driver);
		logger.info("Entering registration details");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		regScreen.enterFirstName(randomString().toUpperCase());
		regScreen.enterLastName(randomString().toUpperCase());
		String emailId = randomString()+"@mail.com";
		System.out.println(emailId);
		regScreen.enterEmail(emailId);
		regScreen.enterTelephone(randomNumber());
		String pass = randomAlphaNum();
		System.out.println(pass);
		regScreen.enterPassword(pass);
		regScreen.enterConfPassword(pass);
		regScreen.click_yes();
		regScreen.click_checkbox();
		regScreen.click_continue();
		logger.info("Assertion for successful validation");
		logger.info("Ending registerationTest_TC001");
		AssertJUnit.assertEquals(regScreen.getSuccessMsg(), p.getProperty("registrationSuccess"));
	}
	
}
