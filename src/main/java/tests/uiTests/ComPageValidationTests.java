package tests.uiTests;

import domain.pages.CommitteesPage;
import domain.pages.HomePage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;

public class ComPageValidationTests {

    @Test
    public void comPageTitleShouldAppearWithChrome(){
        System.setProperty("webdriver.chrome.driver", "resources/chrome-driver");
        WebDriver driver = new ChromeDriver();
        HomePage homePage = new PageFactory().initElements(driver, HomePage.class);
        CommitteesPage committeesPage = new PageFactory().initElements(driver, CommitteesPage.class);

        driver.get("https://www.house.gov");
        homePage.isHomePageZipCodeInputPresent();
        homePage.clickCommitteesLink();
        System.out.println(committeesPage.isCommitteesPageAgricultureLinkDisplayed());
        driver.close();
    }

    @Test
    public void comPageShouldAppearWithFirefox(){
        System.setProperty("webdriver.gecko.driver", "resources/geckodriver 2");
        FirefoxDriver driver = new FirefoxDriver();
        HomePage homePage = new PageFactory().initElements(driver, HomePage.class);
        CommitteesPage committeesPage = new PageFactory().initElements(driver, CommitteesPage.class);

        driver.get("https://www.house.gov");
        homePage.isHomePageZipCodeInputPresent();
        homePage.clickCommitteesLink();
        System.out.println(committeesPage.isCommitteesPageAgricultureLinkDisplayed());
        driver.close();
    }

    @Test
    public void comPageShouldWorkHeadlessTest(){
        System.setProperty("webdriver.chrome.driver", "resources/chrome-driver");
        WebDriver driver = new HtmlUnitDriver();
        HomePage homePage = new PageFactory().initElements(driver, HomePage.class);
        CommitteesPage committeesPage = new PageFactory().initElements(driver, CommitteesPage.class);

        driver.get("https://www.house.gov");
        homePage.isHomePageZipCodeInputPresent();
        homePage.clickCommitteesLink();
        System.out.println(committeesPage.isCommitteesPageAgricultureLinkDisplayed());
        driver.close();
    }

    @Test
    public void comPageCommitteesListOutput(){
        System.setProperty("webdriver.chrome.driver", "resources/chrome-driver");
        WebDriver driver = new ChromeDriver();
        HomePage homePage = new PageFactory().initElements(driver, HomePage.class);
        CommitteesPage committeesPage = new PageFactory().initElements(driver, CommitteesPage.class);

        driver.get("https://www.house.gov");
        homePage.isHomePageZipCodeInputPresent();
        homePage.clickCommitteesLink();
        committeesPage.isCommitteesPageAgricultureLinkDisplayed();
        committeesPage.fetchListOfCommittees();



        driver.close();
    }
}