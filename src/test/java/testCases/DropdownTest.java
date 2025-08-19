package testCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pageObjects.DropDownPage;
import testBase.BaseTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DropdownTest extends BaseTest {
    /*
     Pre-requisite , in Base Class , uncomment line 53 https://practice.expandtesting.com/dropdown
     And then execute the test case from testng2.xml by adding
        <class name="testCases.DropdownTest"/>
     in it
    */
    @Test
    public void getDataFromDD(){
        //Object for DropDown Page Objects file
        DropDownPage dd = new DropDownPage(driver);

        //Object for Select Class for performing operations on Select Dropdown
        Select sel = new Select(dd.countryDD);

        //Getting all options from dropdown and storing in a list of WebElements
        List<WebElement> countries = sel.getOptions();

        //String List to store country names
        List<String> checkCountries = new ArrayList<>();

        //Adding country names to String list from WebElement List
        for (int i=1;i<countries.size();i++){
            System.out.println(countries.get(i).getText());
            checkCountries.add(countries.get(i).getText());
        }

        //Making a copy of String List of country names , this copy will be sorted and stored
        List<String> sortedCountries = new ArrayList<>(checkCountries);

        //Sorting the copied List with Case Insensitive Order
        Collections.sort(sortedCountries,String.CASE_INSENSITIVE_ORDER);

        //Comparing the original country List and sorted country list
        // and checking if they are equal , if yes , means the original country list
        // was being displayed in Alphabetical order
        // If no , means the dropdown is not in alphabetical sorted order
        if (checkCountries.equals(sortedCountries)){
            System.out.println("Countries in sorted order in dropdown");
        }else{
            System.out.println("Countries not in sorted order");
        }
    }
}
