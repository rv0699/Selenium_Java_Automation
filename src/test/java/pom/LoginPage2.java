package pom;

import java.util.ArrayList;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {
	
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
	
	// Approach 2 : With PageFactory
	
	WebDriver driver; 	// Class variable
	
	//Constructor | Element 1 of Page Objects Class
	public LoginPage2(WebDriver driver) {
		/* 
		 Assigning the value of driver from test class to POM class variable
		*/
		this.driver = driver;	
		
		/*
		 * following line is required to initialize all the selectors as driver is not directly
		 * used anywhere in the locators or actions 
		 */
		PageFactory.initElements(driver, this);
	}
	
	//Locators | Element 2 of Page Objects Class
	//Found using selectors hub
	//	By username_input_loc = By.xpath("//input[@placeholder='Username']");
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement username_input_loc;
	
	//	By pass_input_loc = By.xpath("//input[@placeholder='Password']");
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement pass_input_loc;
	
	//	By login_btn_loc = By.xpath("//button[normalize-space()='Login']");
	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement login_btn_loc;
	
	// In order to get Multiple elements using FindBy
	@FindBy(tagName="a")
	public ArrayList<WebElement> li;
	
	//Instead of specifying the selector as defined above , it can also be defined in the following way
	//using How class
	@FindBy(how=How.XPATH,using="//button[normalize-space()='Login']")
	private WebElement login_btn;
	
	//Actions | Element 3 of Page Objects Class
	public void enterUsername(String uname) {
		//		driver.findElement(username_input_loc).sendKeys(uname);
		username_input_loc.sendKeys(uname);
	}
	
	public void enterPassword(String pass) {
		//		driver.findElement(pass_input_loc).sendKeys(pass);
		pass_input_loc.sendKeys(pass);
	}
	
	public void clickLoginBtn() {
		//		driver.findElement(login_btn_loc).click();
		login_btn_loc.click();
	}
	
	
	

}
