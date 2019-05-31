package tests.dbTests;


import org.junit.BeforeClass;
import org.junit.Test;
import utils.Dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/*public class DbTest {
    String queryRead;
    Properties prop = new Properties().load(new FileInputStream("config.properties"));
    Dao dao = null;

    String dbUri = prop.getProperty("dbUri");
    String userName = prop.getProperty("userName");
    String password = prop.getProperty("password");

    public DbTest() throws IOException {
    }


    @Test
    public void myTest() throws SQLException {

        List<String> retrievedStates = dao.getAllRecordsForColumn(dbUri, userName, password, queryRead, "STATE");
        System.out.println(retrievedStates.toString());
    }
}*/
