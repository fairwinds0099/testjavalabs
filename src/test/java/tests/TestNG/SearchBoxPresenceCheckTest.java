package tests.TestNG;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import tests.uiTests.UIAbstractBase;

import java.util.concurrent.TimeUnit;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class SearchBoxPresenceCheckTest extends UIAbstractBase {
     private static Logger logger = Logger.getLogger(SearchBoxPresenceCheckTest.class.getName());

    @Override
    public void SystemSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless","--disable-gpu");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.house.gov");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
    }
    @Test(groups = {"smoke"})
    public void searchBoxShouldPresentAtHomePage(){
        SystemSetUp();
        logger.info(logger.getName() + ": Creating a homepage");
        //Handler consoleHandler = new ConsoleHandler();
        //logger.addHandler(consoleHandler);
        setHomePageObject();
        logger.warning("homepage object can not be invoked");
        homePage.isSearchBoxDisplayed();
    }
}
