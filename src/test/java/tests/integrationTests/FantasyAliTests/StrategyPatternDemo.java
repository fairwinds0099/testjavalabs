package tests.integrationTests.FantasyAliTests;

import org.junit.Test;
import tests.uiTests.UITestBase;

public class StrategyPatternDemo {
    @Test
    public void strategyDesignTest () {
            Context context = new Context(new GetDistrict());
            System.out.println(context.executeStrategy());
        }
    }

