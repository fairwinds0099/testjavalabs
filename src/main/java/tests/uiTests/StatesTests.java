package tests.uiTests;

import domain.pages.DirectoryPage;
import domain.pages.HomePage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class StatesTests extends UITestBase {

    String allstates = "[Alabama, Alaska, American Samoa, Arizona, Arkansas]";
    /**
     * Click representatives link.
     * List by state and district.
     * Call for get all states sorted method from directory page.
     * Create a string variable for expected result with respective values.
     * Check if expected and actual results match.
     */
    @Test
    public void AllStatesShouldSorted() {
        HomePage homePage = new PageFactory().initElements(driver, HomePage.class);
        homePage.clickRepresentativesLink();
        DirectoryPage directoryPage = new PageFactory().initElements(driver, DirectoryPage.class);
        directoryPage.clickListByStateAndDistrict();
        Assert.assertEquals (allstates, directoryPage.getSortedStates().toString());
    }
}
