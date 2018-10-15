package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSingleton {

    private static volatile DbSingleton instance = null;
    private static volatile Connection conn = null;

    private DbSingleton() {
        if (instance != null){
            throw new RuntimeException("Use getInstance method to create");
        }
    }
    public static DbSingleton getInstance(){
        if (instance == null){
            synchronized (DbSingleton.class) {
                if (instance == null){
                    instance = new DbSingleton();
                }
            }
        }
        return instance;
    }
    public Connection getConnection(){
        if(conn == null ){
            synchronized (DbSingleton.class){
                if (conn == null){
                    try {
                        String dbUrl = "jdbc:oracle:thin:@florida.csr9s71rdbw2.us-east-1.rds.amazonaws.com:1521/FLORIDA";
                        String userName = "florida";
                        String password = "miamiflorida";
                        conn = DriverManager.getConnection(dbUrl, userName, password);
                    } catch (SQLException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return conn;
    }
}





