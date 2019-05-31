package suites;

import tests.uiTests.LandOnHomePageTest;
import tests.uiTests.ZipCodePositiveTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.wsTests.SerializationTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SerializationTest.class,
        LandOnHomePageTest.class})

public class SmokeTestingSuite {

}


