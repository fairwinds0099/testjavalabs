package domain.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageWithoutPageFactory {

    WebDriver webDriver;
    WebElement repLink = webDriver.findElement(By.xpath("//*[@id=\"block-mainnavigation\"]/ul/li[1]/a"));

    public HomePageWithoutPageFactory (WebDriver driver){this.webDriver = driver;
    System.out.println("constructor initialized");}



    public void isRepresentativesLinkDisplayed(){
        webDriver.get("https://www.house.gov/representatives");
        repLink.isDisplayed();
    }

    public void clickRepresentatives(){
        webDriver.get("https://www.house.gov/representatives");
        repLink.click();
    }
}