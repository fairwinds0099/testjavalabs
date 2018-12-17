package utils.DbUtils;

import tests.dbTests.DatabaseConnection;

public class OracleConnection {
    public static void main(String[] args) {

        DatabaseConnection.Builder builder = new DatabaseConnection.Builder();
        builder.dbUri("jdbc:oracle:thin:@//florida.csr9s71rdbw2.us-east-1.rds.amazonaws.com").dbPort("1521").dbName("FLORIDA").dbUserName("florida").dbPassword("miamiflorida");
        DatabaseConnection connection = builder.build();
        System.out.println(connection.getDbUri());
        System.out.println(connection.getDbPort());
        System.out.println(connection.getDbName());
        System.out.println(connection.getDbUserName());
        System.out.println(connection.getDbPassword());
    }
}
