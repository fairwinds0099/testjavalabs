package tests.StrategyDesign;

import domain.pages.DirectoryPage;
import domain.pages.HomePage;
import domain.pages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class findYourRepWithRepresentativesLink implements Strategy {
    WebDriver driver;

    @Override
    public String findYourRep(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.house.gov");
        HomePage homePage = new PageFactory().initElements(driver, HomePage.class);
        homePage.clickRepresentativesLink();
        DirectoryPage directoryPage = new PageFactory().initElements(driver, DirectoryPage.class);
        return directoryPage.getYourRep("state-california", 48);
    }

    @Override
    public List<String> findYourRep(String str){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.house.gov");
        HomePage homePage = new PageFactory().initElements(driver, HomePage.class);
        DirectoryPage directoryPage = new PageFactory().initElements(driver, DirectoryPage.class);
        homePage.clickRepresentativesLink();
        return directoryPage.getAllRepresentativeNamesForSelectedState(str);
    }
}
