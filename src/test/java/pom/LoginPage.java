package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	//PageObject class consists of following 3 elements : 
	/*
		1. Constructor -> To initialize the driver 
		2. Locator     -> locator of the element present on the page
		3. Action      -> Action to be taken on the locator (click/enter text etc)
	*/
	
	/*
	 * There are 2 approaches with which Page Object class can be defined : 
	 * 1. With PageFactory
	 * 2. Without PageFactory
	 */
	
	// Approach 1 : Without PageFactory
	
	WebDriver driver; 	// Class variable
	
	//Constructor | Element 1 of Page Objects Class
	public LoginPage(WebDriver driver) {
		/* 
		 Assigning the value of driver from test class to POM class variable
		*/
		this.driver = driver;	
	}
	
	//Locators | Element 2 of Page Objects Class
	//Found using selectors hub
	By username_input_loc = By.xpath("//input[@placeholder='Username']");
	By pass_input_loc = By.xpath("//input[@placeholder='Password']");
	By login_btn_loc = By.xpath("//button[normalize-space()='Login']");
	
	//Actions | Element 3 of Page Objects Class
	public void enterUsername(String uname) {
		driver.findElement(username_input_loc).sendKeys(uname);
	}
	
	public void enterPassword(String pass) {
		driver.findElement(pass_input_loc).sendKeys(pass);
	}
	
	public void clickLoginBtn() {
		driver.findElement(login_btn_loc).click();
	}
	
	
	

}
