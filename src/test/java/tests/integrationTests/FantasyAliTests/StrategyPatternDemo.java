package tests.integrationTests.FantasyAliTests;

import org.junit.Assert;
import org.junit.Test;
import tests.uiTests.UITestBase;

public class StrategyPatternDemo {
    @Test
    public void strategyDesignTest () {
            Context context = new Context(new GetDistrict());
            System.out.println(context.executeStrategy());
        }
  //TODO Static vs Dynamic Polymorphism
        @Test
    public void goToGox(){
        Strategy nameStrategy = new GetName();
            //Assert.assertTrue("expectedResult", nameStrategy.getRepUniqueID());
        }

        @Test
    public void yeniTest(){
        Strategy districtStrategy = new GetDistrict();
        //Assert.assertTrue("expected", districtStrategy.getRepUniqueID());
        }
    }

