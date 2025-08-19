package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement first_name;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement last_name;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement conf_password;
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	private WebElement yes_radio_btn;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement agree_pp;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continue_btn;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	private WebElement reg_success_msg;
	
	public void enterFirstName(String fname) {
		first_name.sendKeys(fname);
	}
	
	public void enterLastName(String lname) {
		last_name.sendKeys(lname);
	}
	
	public void enterEmail(String mail_id) {
		email.sendKeys(mail_id);
	}
	
	public void enterTelephone(String tele) {
		telephone.sendKeys(tele);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void enterConfPassword(String c_pass) {
		conf_password.sendKeys(c_pass);
	}
	
	public void click_yes() {
		yes_radio_btn.click();
	}
	
	public void click_checkbox() {
		agree_pp.click();
	}
	
	public void click_continue() {
		continue_btn.click();
	}
	
	public String getSuccessMsg() {
		try {
			return (reg_success_msg.getText());
		}
		catch(Exception e){
			return (e.getMessage());
		}
	}
		
}
