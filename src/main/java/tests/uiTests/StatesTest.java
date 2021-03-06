package tests.uiTests;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class StatesTest extends UITestBase {

    //TODO this test fails

    String allStates = "[Alabama, Alaska, American Samoa, Arizona, Arkansas]";

    /**
     * Click representatives link.
     * List by state and district.
     * Call for get all states sorted method from directory page.
     * Create a string variable for expected result with respective values.
     * Check if expected and actual results match.
     */
    @Test
    public void directoryShouldContainAllStates() {
        homePage.clickRepresentativesLink();
        directoryPage.clickListByStateAndDistrictLink();
        Assert.assertEquals (directoryPage.getSortedStates().toString(), allStates);
    }
}
