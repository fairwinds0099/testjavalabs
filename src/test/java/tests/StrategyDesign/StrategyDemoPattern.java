package tests.StrategyDesign;

import org.junit.Test;

public class StrategyDemoPattern {
    Strategy repStrategy;
    @Test
    public void strategyDesignTest(){
        Context context = new Context(new findYourRepWithZipCode());
        System.out.println(context.executeStrategy());
    }

    @Test
    public void strategyTesDesign(){
        Context context = new Context(new findYourRepWithRepresentativesLink());
        System.out.println(context.executeStrategy());
    }

    @Test
    public void strategyDesignStatic(){
        Strategy strategy = new findYourRepWithRepresentativesLink();
        System.out.println(strategy.findYourRep("state-virginia"));
    }
}
