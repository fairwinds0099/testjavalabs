package tests.integrationTests.FantasyAliTests;

import org.openqa.selenium.By;
import tests.uiTests.UITestBase;

public class GetName extends UITestBase implements Strategy{
    @Override
    public String getRepUniqueID() {
        return driver.findElement(By.xpath("a")).getText();
    }
}
