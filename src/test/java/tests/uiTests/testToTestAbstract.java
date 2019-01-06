package tests.uiTests;

import org.junit.Test;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class testToTestAbstract extends UIAbstractBase {



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

    @Test
    public void openHomePage(){
        SystemSetUp();
        setHomePageObject();
        homePage.clickRepresentativesLink();
        setDirectoryPageObject();
        directoryPage.isDisplayedDirectoryOfRepresentativesText();
    }
}
