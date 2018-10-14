package dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.lang.Class;

public class DbUtilities {


        String hostName = "pos-experiment.cn1e1hoy5jio.us-east-1.rds.amazonaws.com";
        int port = 1521;
        String dbName = "POS";
        String userName = "gxl";
        String password = "Sb123456";
        String url = String.format("jdbc:oracle:thin:@pos-experiment.cn1e1hoy5jio.us-east-1.rds.amazonaws.com:1521/POS");


    public void addRepresentatives( int id, String state, String district, String firstName, String lastName){
            String sqlCreateRecord = String.format("INSERT INTO REPRESENTATIVES (REP_ID, STATE, DISTRICT, FIRST_NAME, LAST_NAME)" +
                    "VALUES(%d, %s, %s, %s, %s)",id, state, district, firstName, lastName);


        Properties connectionProps = new Properties();
        connectionProps.put("user", userName);
        connectionProps.put("password", password);


            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, connectionProps);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ResultSet resultSet = statement.executeQuery(sqlCreateRecord);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

