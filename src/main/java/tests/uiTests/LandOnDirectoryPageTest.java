package tests.uiTests;

import org.junit.Assert;
import org.junit.Test;

public class LandOnDirectoryPageTest extends UITestBase {
    /**
     * Go to representatives
     * Validate if directory of representatives text displayed.
     */
    @Test
    public void directoryOfRepresentativesShouldDisplayed() {
        homePage.clickRepresentativesLink();
        Assert.assertTrue(directoryPage.isDisplayedDirectoryOfRepresentativesText());

    }
}
