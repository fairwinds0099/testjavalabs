package tests.uiTests;

import org.junit.Assert;
import org.junit.Test;


public class SortingOrderTest extends UITestBase {

    /**
     * Go to representatives.
     * List by state and district.
     * Check if Alabama is the first state to validate listed by state and district.
     */
    @Test
    public void shouldListedByStateAndDistrict() {
        homePage.clickRepresentativesLink();
        directoryPage.clickListByStateAndDistrictLink();
        Assert.assertTrue(directoryPage.isAlabamaTextDisplayed());

    }
}


