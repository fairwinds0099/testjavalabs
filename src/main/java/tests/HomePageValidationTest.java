package tests;

import domain.pages.HomePage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePageValidationTest extends UITestBaseClass{

    @Test
    public void homePageValidation(){
        HomePage homePage = new PageFactory().initElements(driver, HomePage.class);
        assert homePage.validateHomePage();
    }
}
