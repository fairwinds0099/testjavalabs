package tests.uiTests;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class StatesTest extends UITestBase {

    String allStates = "[Alabama, Alaska, American Samoa, Arizona, Arkansas, California, Colorado, Connecticut, Delaware, District of Columbia, Florida, Georgia, Guam, Hawaii, Idaho, Illinois, Indiana, Iowa, Kansas, Kentucky, Louisiana, Maine, Maryland, Massachusetts, Michigan, Minnesota, Mississippi, Missouri, Montana, Nebraska, Nevada, New Hampshire, New Jersey, New Mexico, New York, North Carolina, North Dakota, Northern Mariana Islands, Ohio, Oklahoma, Oregon, Pennsylvania, Puerto Rico, Rhode Island, South Carolina, South Dakota, Tennessee, Texas, Utah, Vermont, Virgin Islands, Virginia, Washington, West Virginia, Wisconsin, Wyoming]";

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
