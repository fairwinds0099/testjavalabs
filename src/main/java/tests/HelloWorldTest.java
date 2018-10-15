package tests;



import domain.HelloWorldForImpl;
import domain.HelloWorldWhileImpl;
import domain.helpers.QueryHandlingHelpers;
import org.testng.annotations.Test;


public class HelloWorldTest {

    HelloWorldWhileImpl whileHello = new HelloWorldWhileImpl();
    HelloWorldForImpl forHello = new HelloWorldForImpl();

    QueryHandlingHelpers helper = new QueryHandlingHelpers();

    @Test
    public void myFirstTest() {
        whileHello.whileLoopFiveTimes();
    }

    public HelloWorldTest(HelloWorldForImpl forHello) {
        this.forHello = forHello;
    }

    public HelloWorldTest(QueryHandlingHelpers helper) {
        this.helper = helper;
    }

    @Test
    public void mySecondTest(){
        forHello.forLoopFiveTimes();
    }

    public HelloWorldTest(HelloWorldWhileImpl whileHello) {
        this.whileHello = whileHello;
    }

}
