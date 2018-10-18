package tests;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class DbUtils {

    static final String dbUri = "jdbc:oracle:thin:@//florida.csr9s71rdbw2.us-east-1.rds.amazonaws.com:1521/FLORIDA";
    static final String userName = "florida";
    static final String password = "miamiflorida";

    public static void main (String [] args) throws SQLException {

        Connection conn = getConnection (dbUri, userName, password);

        System.out.println ("Connection Successful");

        String query = "INSERT INTO ADDRESS (ID, STREETNAME, CITY, ZIPCODE, STATE)" +
                "VALUES(7, '333 State St', 'Mc Lean', '44044', 'NJ')";

        Statement statement = conn.prepareStatement(query);

        ResultSet resultSet = statement.executeQuery(query);
    }

}
