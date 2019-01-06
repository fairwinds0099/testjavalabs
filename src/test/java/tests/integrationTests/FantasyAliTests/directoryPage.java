package tests.integrationTests.FantasyAliTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class directoryPage implements CommonMethods {
    WebDriver driver;
    @Override
    public void getName(String xpath) {
         System.out.println(driver.findElement(By.xpath(xpath)));
    }

    @Override
    public void getParty(String xpath) {
        System.out.println(driver.findElement(By.xpath(xpath)));
    }
}
