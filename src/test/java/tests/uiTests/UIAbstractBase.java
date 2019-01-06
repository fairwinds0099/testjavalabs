package tests.uiTests;

import domain.pages.DirectoryPage;
import domain.pages.HomePage;
import domain.pages.SearchResultsPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public abstract class UIAbstractBase {
        //TODO polymorphism
        //TODO create a selenium ui test without using page object factory.
        public String name;
        public WebDriver driver;
        public HomePage homePage;
        public DirectoryPage directoryPage;
        public SearchResultsPage searchResultsPage;



        public abstract void SystemSetUp ();

        public void setHomePageObject(){
            homePage = new PageFactory().initElements(driver, HomePage.class);
        }

        public void setDirectoryPageObject(){
            directoryPage = new PageFactory().initElements(driver, DirectoryPage.class);
        }

        public void setSearchResultsPageObject(){
            searchResultsPage =new PageFactory().initElements(driver, SearchResultsPage.class);
        }

        public void driverQuit() {
            driver.close();
            driver.quit();
        }
    }


