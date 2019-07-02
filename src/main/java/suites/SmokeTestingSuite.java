package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.wsTests.SerializationTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SerializationTest.class
})

public class SmokeTestingSuite {

}


