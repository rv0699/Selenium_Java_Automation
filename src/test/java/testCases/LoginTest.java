package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;
import utilities.DataProviders;

public class LoginTest extends BaseTest{
	
	//Name of dataProvider should be the same as given in DataProviders class
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups = {"Sanity","Master"})
	void TC003_LoginTestDDT(String email,String pswd,String exp) {
		HomePage hp = new HomePage(driver);
		logger.info("Clicking on My account link");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		hp.click_my_acc_link();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		logger.info("Clicking on Login link");
		hp.click_login_link();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		LoginPage lp = new LoginPage(driver);
		logger.info("Entering login details");
		lp.enterEmail(email);
		lp.enterPassword(pswd);
		lp.clickLoginBtn();
		
		MyAccountPage mp = new MyAccountPage(driver);
		Boolean accStatus = mp.isMyAccountPageExists();
		
		
//		Valid credentials -> login successful -> TC pass -> logout
//						  -> Login unsuccessful -> TC fail
//						  
//      Invalid credentials -> login successful -> TC fail -> logout
//        					-> login unsuccessful -> TC pass
		
		if(exp.equalsIgnoreCase("valid")) {
			if(accStatus) {
				hp.click_my_acc_link();
				mp.logout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertFalse(false);
			}
		}
		
		if(exp.equalsIgnoreCase("invalid")) {
			if(accStatus) {
				hp.click_my_acc_link();
				mp.logout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertFalse(false);
			}
		}

		
	}
	
}
