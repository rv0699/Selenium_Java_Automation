package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	//Constructor | Element 1
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//Locators | Element 2
	@FindBy(xpath="//span[normalize-space()='My Account']")
	private WebElement my_acc_link;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	private WebElement register_link;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	private WebElement login_link;
	
	
	//Actions
	public void click_my_acc_link() {
		my_acc_link.click();
	}
	
	public void click_reg_link() {
		register_link.click();
	}
	
	public void click_login_link() {
		login_link.click();
	}
}
