import com.HelloWorldForImpl;
import com.HelloWorldWhileImpl;
import org.junit.Test;


public class HelloWorldTest {

    HelloWorldWhileImpl whileHello = new HelloWorldWhileImpl();
    HelloWorldForImpl forHello = new HelloWorldForImpl();
    @Test
    public void myFirstTest() {
        whileHello.whileLoopFiveTimes();
    }
    @Test
    public void mySecondTest(){
        forHello.forLoopFiveTimes();
    }
}
