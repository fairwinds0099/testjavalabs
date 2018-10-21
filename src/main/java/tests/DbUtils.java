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

        String queryCreate = "INSERT INTO ADDRESS (ID, STREETNAME, CITY, ZIPCODE, STATE)" +
                "VALUES(7, '311 True St', 'Richmond', '54544', 'VA')";

        Statement stCreate = conn.prepareStatement(queryCreate);

        ResultSet rsltCr = stCreate.executeQuery(queryCreate);

        System.out.println (rsltCr);

        String queryRead = "SELECT * FROM ADDRESS WHERE ZIPCODE=54544";

        Statement stRead = conn.prepareStatement(queryRead);

        ResultSet rsltRe = stRead.executeQuery(queryRead);

        System.out.println (rsltRe);

        String queryUpdate = "UPDATE ADDRESS SET CITY = 'Miami', ZIPCODE='22222' WHERE ID='7'";

        Statement stUpdate = conn.prepareStatement(queryUpdate);

        ResultSet rsltUp = stUpdate.executeQuery(queryUpdate);

        System.out.println(rsltUp);

        String queryDelete = "DELETE FROM ADDRESS WHERE ID=7";

        Statement stDelete = conn.prepareStatement(queryDelete);

        ResultSet rsltDel = stDelete.executeQuery(queryDelete);
    }

}
