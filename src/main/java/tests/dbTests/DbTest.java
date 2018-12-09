package tests.dbTests;


import org.junit.BeforeClass;
import org.junit.Test;
import utils.DbUtils.Dao;
import utils.FileHelpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class DbTest extends Dao {
    String queryRead;
    static String dbUri;
    static String userName;
    static String password;
    static Properties prop = new Properties();


    @BeforeClass
    public static void init() throws IOException {
        prop.load(new FileInputStream("resources/config.properties"));
        dbUri = prop.getProperty("dbUriGx");
        userName = prop.getProperty("userNameGx");
        password = prop.getProperty("passwordGx");
    }

    @Test
    public void myTest() throws SQLException {
        List<String> retrievedStates = getAllRecordsForColumn(dbUri, userName, password, queryRead, "STATE");
        System.out.println(retrievedStates.toString());
    }

    @Test
    public void shouldInsertData() {
        executeBatch(dbUri,userName,password,FileHelpers.getQueriesFromFile("resources/insertReps.sql",";"));
        }
    }

