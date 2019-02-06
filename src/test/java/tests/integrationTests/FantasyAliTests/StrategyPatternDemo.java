package tests.integrationTests.FantasyAliTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import tests.uiTests.UITestBase;

public class StrategyPatternDemo extends UITestBase{
    Strategy nameStrategy;
    @Test
    public void strategyDesignTest () {
        Context context = new Context(new GetDistrict());
            System.out.println(context.executeStrategy());
        }
  //TODO Static vs Dynamic Polymorphism
        @Test
    public void goToGox(){
        Strategy nameStrategy = new GetName();
        System.out.println(nameStrategy.getRepUniqueID());
            //Assert.assertTrue("expectedResult", nameStrategy.getRepUniqueID());
        }

        @Test
    public void yeniTest(){
        Strategy districtStrategy = new GetDistrict();
        //Assert.assertTrue("expected", districtStrategy.getRepUniqueID());
        }
    }

