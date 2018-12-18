package utils.DbUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoBuilder {

    public List<String> getAllRecordsForColumn(ServerConfig dbServer, String sqlQuery, String columnName) {
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
        return listOfColumns;
    }




    

}



