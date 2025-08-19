package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropDownPage extends BasePage{
    public DropDownPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="country")
    public WebElement countryDD;

    public void clickCountryDropdown(){
        countryDD.click();
    }
}
