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
    String query = fileHelpers.getFileContent("insertReps.sql");

    //TODO try adding more than one rep within one query
    //This is an insert into query
    @Test
    public void addRepresentativeTest() {
        DaoHelper.runSqlQuery(rdsAws, query);
    }

    //TODO
    @Test
    public void retrieveRepresentativesTest() {

    }

    //TODO
    @Test
    public void deleteRepresentativeTest() {

    }

    //TODO
    @Test
    public void updateRepresentativeTest() {

    }
}
