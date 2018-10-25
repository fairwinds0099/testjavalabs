package utils.DbUtils;

import java.sql.*;

public class Dao {
        //TODO: create a new branch


        String dbUri = "jdbc:oracle:thin:@//florida.csr9s71rdbw2.us-east-1.rds.amazonaws.com:1521/FLORIDA";
        String userName = "florida";
        String password = "miamiflorida";

        // We need to make these variables final so they cannot be changed by someone else
        final String queryCreate = "INSERT INTO ADDRESS (ID, STREETNAME, CITY, ZIPCODE, STATE)" +
                "VALUES(7, '311 True St', 'Richmond', '54544', 'VA')";
        final String queryRead = "SELECT * FROM ADDRESS WHERE ZIPCODE=54544";
        final String queryUpdate = "UPDATE ADDRESS SET CITY = 'Miami', ZIPCODE='22222' WHERE ID='7'";
        final String queryDelete = "DELETE FROM ADDRESS WHERE ID=7";

        // let us extract this and make a method
        //Class.forName("oracle.jdbc.driver.OracleDriver");(Bunu kullanmama gerek var mi bilemedim, hata verip duruyor.
        Connection conn = DriverManager.getConnection(dbUri, userName, password);
        Statement statement = conn.createStatement();

    public Dao() throws SQLException {
    }


    //ResultSet rs1 = statement.executeQuery(queryCreate);
        //ResultSet rs2 = statement.executeQuery(queryUpdate);
        //ResultSet rs3 = statement.executeQuery(queryDelete);

                public void updateQuery () throws SQLException {
                    try {
                        statement.executeQuery(queryUpdate);
                    } catch (SQLException e) {
                        e.getErrorCode();
                    }
                }
                public void createQuery () throws SQLException {
                    try {
                        statement.executeQuery(queryCreate);
                    } catch (SQLException e) {
                        e.getStackTrace();
                    }
                }
                public void deleteQuery () throws SQLException {
                    try {
                        statement.executeQuery(queryDelete);
                    } catch (SQLDataException e) {
                        e.getStackTrace();
                    }
                }

            //if (query == queryCreate){
              //  ResultSet rs1 = statement.executeQuery(queryCreate);
                //return rs1;
            //}
            //if (query == queryUpdate){
              //  ResultSet rs2 = statement.executeQuery(queryUpdate);
                //return rs2;
            //}
            //if (query == queryDelete){
              //  ResultSet rs3 = statement.executeQuery(queryDelete);
                //return rs3;
            //}


            //return null;


        // do not leave blanks between lines
        // as you will see these are all executequery methods
        // you can extract  an execute sql query methods


        public ResultSet readQuery() throws SQLException {
            Statement statement = conn.prepareStatement(queryRead);
            ResultSet rs = statement.executeQuery(queryRead);
            return rs;
        }
        // except this one read. Because when you read you get something back and  need to get that info
        // call this method in DbTest
        // and do some exception handling


        //TODO post this part is added after Ali's merge
}


