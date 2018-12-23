package utils;

import utils.ServerConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoHelper {

    public static List<String> getAllRecordsForColumn(ServerConfig dbServer, String sqlQuery, String columnName) {
        String dbUri = String.format("jdbc:oracle:thin:@//%s:%d/%s", dbServer.getHostName(), dbServer.getPort(), dbServer.getDbName());
        List<String> listOfColumns = new ArrayList<String>();

        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(dbUri, dbServer.getUserName(), dbServer.getPassword());
            statement = connection.prepareStatement(sqlQuery);
            rs = statement.executeQuery(sqlQuery);

            while (rs.next()) {
                listOfColumns.add(rs.getString(columnName));
            }

        } catch (SQLException e) {
            // do nothing
        }
        System.out.println("connected to DB URI: " + dbUri);
        System.out.println("executed SQL query: " + sqlQuery);
        System.out.println("retrieved list of values in column: " + columnName);
        return listOfColumns;
    }


    public static void runSqlQuery(ServerConfig dbServer, String sqlQuery) {
        String dbUri = String.format("jdbc:oracle:thin:@//%s:%d/%s", dbServer.getHostName(),
                dbServer.getPort(), dbServer.getDbName());

        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(dbUri, dbServer.getUserName(), dbServer.getPassword());
            statement = connection.createStatement();
            statement.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("connected to DB URI: " + dbUri);
        System.out.println("executed SQL query: " + sqlQuery);
    }

    //the follwing command should un first. make sure ojdbc8 is in m2 and add dependency to pom.xml
    //mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=12.2.0.1 -Dpackaging=jar -Dfile=/Users/gx/Desktop/ExperimentsSw/ojdbc8.jar -DgeneratePom=true
}



