package tests.StrategyDesign;

import domain.pages.HomePage;
import domain.pages.SearchResultsPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class findYourRepWithZipCode implements Strategy {
    WebDriver driver;


    @Override
    public String findYourRep() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.house.gov");
        HomePage homePage = new PageFactory().initElements(driver, HomePage.class);
        homePage.isSearchBoxDisplayed();
        homePage.enterZipCodeAndSubmit("92656");
        SearchResultsPage searchResultsPage = new PageFactory().initElements(driver, SearchResultsPage.class);
        return searchResultsPage.searchRepResults().get(1);
    }

    @Override
    public List<String> findYourRep(String str) {
        return null;
    }
}
