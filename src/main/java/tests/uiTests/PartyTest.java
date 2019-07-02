package tests.uiTests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PartyTest extends UITestBase {
    /**
     * Go to representatives.
     * List by state and district.
     * Call for getPartyByRepresentative method from directory page to retrieve party name of selected representative.
     */
    @Test
    public void partyOfRepShouldDemonstrated(){
       homePage.clickRepresentativesLink();
       //mlkmlg
        directoryPage.clickListByStateAndDistrictLink();
        assertEquals("D", directoryPage.getPartyByRepresentative("Grijalva"));
    }
}
