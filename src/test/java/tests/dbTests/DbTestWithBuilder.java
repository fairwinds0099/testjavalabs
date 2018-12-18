package tests.dbTests;

import org.junit.Test;
import utils.DaoHelper;
import utils.FileHelpers;
import utils.ServerConfig;

public class DbTestWithBuilder {

    ServerConfig rdsAws = ServerConfig.getConfiguration()
            .withHostName("mydbinstance.cn1e1hoy5jio.us-east-1.rds.amazonaws.com")
            .withPort(1521)
            .withDbName("ORCL")
            .withUserName("fairwinds")
            .withPassword("Sb123456")
            .build();

    FileHelpers fileHelpers = new FileHelpers();
    //String query = fileHelpers.getFileContent("insertReps.sql");
String query = "INSERT INTO REPRESENTATIVES (NAME, PARTY) VALUES ('GO', 'ZAWAY')";
    @Test
    public void myTest() {
        DaoHelper.runSqlQuery(rdsAws, query);
    }

}
