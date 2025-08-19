package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	private WebElement my_acc_heading;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	private WebElement logout_link;


	public String verifyMyAccountHeading() {
		return my_acc_heading.getText();
	}
	
	public void logout() {
		logout_link.click();
	}
	
	public boolean isMyAccountPageExists()   // MyAccount Page heading display status
	{
		try {
			return (my_acc_heading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}
}
