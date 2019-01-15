package tests.integrationTests.FantasyAliTests;

import domain.pages.HomePageWithoutPageFactory;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class testWithoutPageFactory {
    WebDriver chromeDriver;
    HomePageWithoutPageFactory homePageWithoutPageFactory;


    @Test
    public void isRepresentativesLinkDisplayed() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        chromeDriver = new ChromeDriver();
        homePageWithoutPageFactory = new HomePageWithoutPageFactory(chromeDriver);
        homePageWithoutPageFactory.isRepresentativesLinkDisplayed();
    }

    @Test
    public void clickRepLink(){
        HomePageWithoutPageFactory homePageWithoutPageFactory = new HomePageWithoutPageFactory(chromeDriver);
        homePageWithoutPageFactory.clickRepresentatives();
    }


}