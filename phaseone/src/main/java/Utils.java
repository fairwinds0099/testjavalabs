
public class Utils {

  public void forLoopTenTimes() {
    for (int i = 0; i < 10; i++) {
      System.out.println("Hello World");
    }
  }

  protected void openSession() {
    System.out.println("This method opens a session in Linux Server");
  }

  public static void connectToDatabase() {
    System.out.println("This method connectes to a remote database");
  }

  // TODO please add a method to connecte to the below database
  //String hostName = "pos-experiment.cn1e1hoy5jio.us-east-1.rds.amazonaws.com";
  //    int port = 1521;
  //    String dbName = "POS";
  //    String userName = "pos_user";
  //    String password = "Sb123456";

}
