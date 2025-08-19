package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="input-email")
	private WebElement email_input;
	
	@FindBy(id="input-password")
	private WebElement password_input;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement login_btn;
	
	
	public void enterEmail(String email) {
		email_input.sendKeys(email);
	}
	
	public void enterPassword(String pass) {
		password_input.sendKeys(pass);
	}
	
	public void clickLoginBtn() {
		login_btn.click();
	}
}
