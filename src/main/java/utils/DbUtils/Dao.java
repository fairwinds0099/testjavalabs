package utils.DbUtils;

import java.sql.*;

public class Dao {

        String dbUri = "jdbc:oracle:thin:@//florida.csr9s71rdbw2.us-east-1.rds.amazonaws.com:1521/FLORIDA";
        String userName = "florida";
        String password = "miamiflorida";

        Connection conn = DriverManager.getConnection(dbUri, userName, password);
        Statement statement = conn.createStatement();

    public Dao() throws SQLException {
    }
                public void updateQuery (String queryupdate){
                    try {
                        Connection conn = DriverManager.getConnection(dbUri, userName, password);
                        Statement statement = conn.createStatement();
                                statement.executeQuery(queryupdate);
                    } catch (SQLException e) {
                        e.getErrorCode();
                    }
                }
                public void createQuery(String querycreate){
                    try {
                        Connection conn = DriverManager.getConnection(dbUri, userName, password);
                        Statement statement = conn.createStatement();
                                statement.executeQuery(querycreate);
                    } catch (SQLException e) {
                        e.getErrorCode();
                    }
                }
                public void deleteQuery (String querydelete) {
                    try {
                        Connection conn = DriverManager.getConnection(dbUri, userName, password);
                        Statement statement = conn.createStatement();
                                statement.executeQuery(querydelete);
                    } catch (SQLException e) {
                        e.getErrorCode();
                    }
                }
                
        public ResultSet readQuery(String queryread) throws SQLException {
            Statement statement = conn.prepareStatement(queryread);
            ResultSet rs = statement.executeQuery(queryread);
            return rs;
        }

}


