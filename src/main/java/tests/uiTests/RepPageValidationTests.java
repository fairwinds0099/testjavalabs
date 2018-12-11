package tests.uiTests;

import domain.pages.HomePage;
import domain.pages.RepresentativesPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class RepPageValidationTests {

    @Test
    public void repPageLogoShouldAppearWithChrome(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver4mac");
        WebDriver driver = new ChromeDriver();
        HomePage homePage = new PageFactory().initElements(driver, HomePage.class);
        RepresentativesPage representativesPage = new PageFactory().initElements(driver, RepresentativesPage.class);

        driver.get("https://www.house.gov");
        homePage.isHomePageZipCodeInputPresent();
        homePage.clickRepresentativesLink();
        System.out.println(representativesPage.isRepresentativesPageStateNameDisplayed());
        driver.close();
    }

    @Test
    public void repPageLogoShouldAppearWithFirefox(){
        System.setProperty("webdriver.gecko.driver", "resources/geckodriver 2");
        FirefoxDriver driver = new FirefoxDriver();
        HomePage homePage = new PageFactory().initElements(driver, HomePage.class);
        RepresentativesPage representativesPage = new PageFactory().initElements(driver, RepresentativesPage.class);

        driver.get("https://www.house.gov");
        homePage.isHomePageZipCodeInputPresent();
        homePage.clickRepresentativesLink();
        System.out.println(representativesPage.isRepresentativesPageStateNameDisplayed());
        driver.close();
    }

    @Test
    public void repPageShouldWorkHeadlessTest(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver4mac");
        ChromeOptions chromeOptions= new ChromeOptions();
        chromeOptions.addArguments("headless");
        WebDriver driver = new ChromeDriver(chromeOptions);
        HomePage homePage = new PageFactory().initElements(driver, HomePage.class);
        RepresentativesPage representativesPage = new PageFactory().initElements(driver, RepresentativesPage.class);

        driver.get("https://www.house.gov");
        homePage.isHomePageZipCodeInputPresent();
        homePage.clickRepresentativesLink();
        System.out.println(representativesPage.isRepresentativesPageStateNameDisplayed());
        driver.close();
    }
}