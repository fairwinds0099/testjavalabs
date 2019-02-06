package tests.integrationTests.FantasyAliTests;

import domain.pages.HomePageWithoutPageFactory;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class testWithoutPageFactory {

    WebDriver chromeDriver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver chromeDriver = new ChromeDriver();
    }

    @Test
    public void isRepresentativesLinkDisplayed() {

        //chromeDriver = new ChromeDriver();
        //homePageWithoutPageFactory = new HomePageWithoutPageFactory(chromeDriver);
        HomePageWithoutPageFactory homePageWithoutPageFactory = new HomePageWithoutPageFactory(chromeDriver);
        homePageWithoutPageFactory.isRepresentativesLinkDisplayed();
    }

    @Test
    public void clickRepLink(){
        HomePageWithoutPageFactory homePageWithoutPageFactory = new HomePageWithoutPageFactory(chromeDriver);
        homePageWithoutPageFactory.clickRepresentatives();
    }


}