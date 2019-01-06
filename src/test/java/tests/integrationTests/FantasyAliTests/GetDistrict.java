package tests.integrationTests.FantasyAliTests;

import domain.pages.DirectoryPage;
import domain.pages.HomePage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import tests.uiTests.UITestBase;

import java.util.concurrent.TimeUnit;

public class GetDistrict extends UITestBase implements Strategy {
    //WebDriver driver;
    //HomePage homePage = new PageFactory().initElements(driver, HomePage.class);
    //DirectoryPage directoryPage = new PageFactory().initElements(driver, DirectoryPage.class);
    //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
    //driver = new ChromeDriver();
    //driver.get("https://www.house.gov");
    //driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);



    @Override
    public String getRepUniqueID() {
        homePage.clickRepresentativesLink();
        return directoryPage.getDistrictsForSelectedState("alabama").get(0);
    }
}
