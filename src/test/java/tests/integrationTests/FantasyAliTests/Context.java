package tests.integrationTests.FantasyAliTests;

public class Context {
    private Strategy strategy;
    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public String executeStrategy(){
        return strategy.getRepUniqueID();
    }
}
