package tests.TestNG;


import domain.pages.DirectoryPage;
import domain.pages.HomePage;
import domain.pages.SearchResultsPage;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

@Listeners(tests.TestNG.ListenerTest.class)

public class ZipCodeNegativeTestTestNG {

    public String name;
    public WebDriver driver;
    public HomePage homePage;
    public DirectoryPage directoryPage;
    public SearchResultsPage searchResultsPage;

    @BeforeClass
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



    @DataProvider(name = "ZipCode")
    public static Object[][] zipCodes() {
        return new Object[][] { {"92656"}, {"42156"}};
    }

    @DataProvider(name = "ZipCodeNegative")
    public static Object[][] negativeZipCodes() {
        return new Object[][] { {"3455"}, {"1234"}};
    }


        //TODO add more data, bu testin aynisini testng ile yaz dataprovider kullan, TestNG package i yap, icinde hem testng xml olsun hem de data provider olsun hem logging.Logger.info
        //TODO Sl4j nedir? Listeners (ayni paketin icine koy)
        @Test(dataProvider = "ZipCode")
            public void singleRepSearchWithZipSearchShouldPassForPositiveData(String zipCodeNegative) {
            searchResultsPage.enterZipCodeAndSubmit(zipCodeNegative);
            Assert.assertTrue(searchResultsPage.isRepImagePresent());
        }

    @Test(dataProvider = "ZipCodeNegative", groups = {"smoke"})
    public void singleRepSearchWithZipSearchShouldPassForNegativeData(String zipCodeNegative) {
        searchResultsPage.enterZipCodeAndSubmit(zipCodeNegative);
        Assert.assertFalse(searchResultsPage.isRepImagePresent());
    }

    }



