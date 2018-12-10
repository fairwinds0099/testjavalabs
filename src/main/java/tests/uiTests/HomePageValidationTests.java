package tests.uiTests;

import domain.pages.HomePage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePageValidationTests {

    @Test
    public void homePageLogoShouldAppearWithChrome(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver4mac");
        WebDriver driver = new ChromeDriver();
        HomePage homePage = new PageFactory().initElements(driver, HomePage.class);

        driver.get("https://www.house.gov");
        System.out.println(homePage.isHomePageZipCodeInputPresent());
        driver.close();
    }

    @Test
    public void homePageLogoShouldAppearWithFirefox(){
        System.setProperty("webdriver.gecko.driver", "resources/geckodriver 2");
        FirefoxDriver driver = new FirefoxDriver();
        HomePage homePage = new PageFactory().initElements(driver, HomePage.class);

        driver.get("https://www.house.gov");
        System.out.println(homePage.isHomePageZipCodeInputPresent());
        driver.close();
    }

    @Test
    public void homePageShouldWorkHeadlessTest(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver4mac");
        WebDriver driver = new HtmlUnitDriver();
        HomePage homePage = new PageFactory().initElements(driver, HomePage.class);

        driver.get("https://www.house.gov");
        System.out.println(homePage.isHomePageZipCodeInputPresent());
        driver.close();
    }
}