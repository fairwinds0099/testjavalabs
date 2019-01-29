package tests.TestNG;

import domain.pages.DirectoryPage;
import domain.pages.HomePage;
import domain.pages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ZipCodeTestWithXML {
    public WebDriver driver;
    public HomePage homePage;
    public DirectoryPage directoryPage;
    public SearchResultsPage searchResultsPage;

    @BeforeClass
    public void SystemSetUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.house.gov");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        homePage = new PageFactory().initElements(driver, HomePage.class);
        directoryPage = new PageFactory().initElements(driver, DirectoryPage.class);
        searchResultsPage = new PageFactory().initElements(driver, SearchResultsPage.class);
    }

    @Test
    @Parameters({"zipCodePositive"})
    public void singleRepSearchWithZipSearchShouldPassForPositiveData(@Optional("92620") String zipCodePositive) {
        searchResultsPage.enterZipCodeAndSubmit(zipCodePositive);
        Assert.assertTrue(searchResultsPage.isRepImagePresent());
    }
}
