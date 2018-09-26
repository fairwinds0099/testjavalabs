import com.HelloWorldImpl;
import org.junit.Test;

public class HelloWorldTest {
    int i;
    HelloWorldImpl myHello = new HelloWorldImpl();

    @Test
    public void myFirstTest() {
        i = myHello.forLoopFiveTimes();
        System.out.println(i);
    }
}
