import org.junit.Assert;
import org.junit.Test;

public class HelloWorld {

  @Test
  public void myFirstTest() {

    forLoopTenTimes();
  }

  private void forLoopTenTimes() {
    for (int i = 0; i < 10; i++) {
      System.out.println("Hello World");
    }
  }
}
