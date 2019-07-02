package utils;

/*
the columns and data types for columns hould be re-arranged for the create column
 */


import java.sql.*;
import java.util.List;

public class MemDbUtils {

    public static void createCustomTable(String tableName) throws ClassNotFoundException {

        final String CREATE_TABLE_QUERY = String.format("create table %s (COL1 varchar(50),  COL2 (varchar(100), COL3 (varchar(500)))", tableName);
        final String DROP_TABLE_QUERY = String.format("drop table if exists %s", tableName);

        try {
            Connection connection;
            Statement statement;

            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/test", "test", "");
            statement = connection.createStatement();
            statement.execute(DROP_TABLE_QUERY);
            statement.execute(CREATE_TABLE_QUERY);

            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    /*
    columns in query and data types in setprepared statement shouldbe customized
     */
    public static void insertIntoCustomTable(String tableName, List<String> list1, List<String> list2, List<String> list3) {

        final String INSERT_QUERY = "insert into" + tableName + "(COL1, COL2, COL3) values (?, ? ?)";

        try {
            Connection connection;
            PreparedStatement preparedStatement;
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/test", "test", "");
            preparedStatement = connection.prepareStatement(INSERT_QUERY);
            int i = 0;
            for (String item : list1) {
                preparedStatement.setString(1, list1.get(i));
                preparedStatement.setString(2, list1.get(i));
                preparedStatement.setString(3, list1.get(i));
                preparedStatement.execute();
                i++;
            }
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
