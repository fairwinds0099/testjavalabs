package suites;

import tests.uiTests.ZipCodePositiveTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.wsTests.SerializationTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ SerializationTest.class, ZipCodePositiveTest.class})

public class SmokeTestingSuite {

}


