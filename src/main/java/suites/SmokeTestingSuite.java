package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.uiTests.StatesTests;
import tests.uiTests.ZipCodePositiveTests;
import tests.wsTests.SerializationTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({ SerializationTests.class})

public class SmokeTestingSuite {

}


