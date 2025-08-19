package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;

public class LoginTestWithDataProviderInside extends BaseTest{
	@Test(dataProvider="loginCreds",groups ={"Regression","Master"})
	void loginTest_Tc001(String email,String pswd) {
		HomePage hp = new HomePage(driver);
		logger.info("Clicking on My account link");
		hp.click_my_acc_link();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		logger.info("Clicking on Login link");
		hp.click_login_link();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		LoginPage lp = new LoginPage(driver);
		logger.info("Entering login details");
//		lp.enterEmail(p.getProperty("email"));
//		lp.enterPassword(p.getProperty("password"));
		lp.enterEmail(email);
		lp.enterPassword(pswd);
		lp.clickLoginBtn();
		
		MyAccountPage mp = new MyAccountPage(driver);
		String actualHeading = mp.verifyMyAccountHeading();
		logger.info("Verifying my account heading for successful login");
		Assert.assertEquals(actualHeading, p.getProperty("myAccountHeading"));
		
	}

	/*
	 * Methods defined with @DataProvider annotation create data to be passed to the Test method, test method
	 * uses the name given to method defined with @DataProvider annotation  .
	 * 
	 * Just need to specify (dataProvider="name_of_dataProvider") in @Test
	 * 
	 * We can also execute test case for some specific data using the indices parameter, like if we just
	 * want to execute test case for first and last set of data
	 * 
	 * For below dataProvider , we can specify indices in parameter as : 
	 * 	@DataProvider(name="loginCreds",indices={0,4})

	 * 
	 */
	@DataProvider(name="loginCreds")
	Object[][] loginData() {
		Object data[][] = {
				{"abcd@mail.com","pass1234"},
				{"ab0987@mail.com","paaa1234"},
				{"abcd@mail123.com","pass0004"},
				{"abcd@gmail.com","pass@1234"},
				{"defg@mail.com","pass#1234"},
				{"dOtiOE@mail.com","TLPme9e"}
		};
		
		return data;
	}
}
