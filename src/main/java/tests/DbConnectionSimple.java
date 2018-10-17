package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class DbConnectionSimple {

    static final String dbUrl = "jdbc:oracle:thin:@//florida.csr9s71rdbw2.us-east-1.rds.amazonaws.com:1521/FLORIDA";
    static final String userName = "florida";
    static final String password = "miamiflorida";

    public static void main (String [] args) throws SQLException {

        Connection conn = getConnection (dbUrl, userName, password);

        System.out.println ("Connection Successful");

    }

}
