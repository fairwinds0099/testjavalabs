package tests.integrationTests.FantasyAliTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class leadershipPage implements CommonMethods {
    WebDriver driver;
    @Override
    public void getName(String xpath) {
        String repName = driver.findElement(By.xpath(xpath)).getText();
        String rep = repName.substring(4);
    }

    @Override
    public void getParty(String xpath) {
    String party = driver.findElement(By.xpath(xpath)).getText();
    String par = String.valueOf(party.charAt(0));
    }
}
