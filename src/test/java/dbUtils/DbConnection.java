package dbUtils;
import java.sql.*;

public class DbConnection {



    public static void DbConnect () throws SQLException, ClassNotFoundException{

        // TODO please add a method to connect to the below database
        String url = "pos-experiment.cn1e1hoy5jio.us-east-1.rds.amazonaws.com";
        int port = 1521;
        String dbName = "POS";
        String userName = "pos_user";
        String password = "Sb123456";
        String jdbcUrl = "jdbc:oracle:thin://" + url + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
        //System.out.println("herhangibirsey")

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");}
        catch(Exception e){ System.out.println(e);}
        try{
        Connection con = DriverManager.getConnection(jdbcUrl);
            String query = " insert into representatives (REP_ID, STATE, DISTRICT, FIRST_NAME, LAST_NAME, PARTY, PHONE, EMAIL, COMMITTEE_ASSIGN, )"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt (1, 51);
            preparedStmt.setString (2, "California");
            preparedStmt.setInt   (3, 2);
            preparedStmt.setString(4, "Omer");
            preparedStmt.setString    (5, "Hakyemez");
            preparedStmt.setString    (6, "IT");
            preparedStmt.setString    (7, "757-324-1666");
            preparedStmt.setString    (8, "abc@gmail.com");
            preparedStmt.setString    (9, "Comm");
            preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    }


