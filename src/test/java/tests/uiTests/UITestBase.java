package tests.uiTests;

import domain.pages.DirectoryPage;
import domain.pages.HomePage;
import domain.pages.SearchResultsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class UITestBase {
    //TODO polymorphism
    //TODO create a selenium ui test without using page object factory.
    public String name;
    public WebDriver driver;
    public HomePage homePage;
    public DirectoryPage directoryPage;
    public SearchResultsPage searchResultsPage;

    @Before
    public void SystemSetUp() {
        name = new String("aLi");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless","--disable-gpu");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.house.gov");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        homePage = new PageFactory().initElements(driver, HomePage.class);
        directoryPage = new PageFactory().initElements(driver, DirectoryPage.class);
        searchResultsPage =new PageFactory().initElements(driver, SearchResultsPage.class);
        //homepage = new HomePage();
    }

    @After
    public void driverQuit() {
        driver.close();
        driver.quit();
    }
}
