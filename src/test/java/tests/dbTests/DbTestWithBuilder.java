package tests.dbTests;

import org.junit.Test;
import utils.DaoHelper;
import utils.DbHelpers.Dao;
import utils.ServerConfig;

public class DbTestWithBuilder {

    ServerConfig rdsAws = ServerConfig.getConfiguration()
            .withHostName("orcl.cn1e1hoy5jio.us-east-1.rds.amazonaws.com")
            .withPort(1521)
            .withDbName("ORCL")
            .withPassword("gxl")
            .withUserName("Sb123456")
            .build();

    @Test
    public void myTest() {
        DaoHelper.getAllRecordsForColumn(rdsAws, "select * from reps", "NAME" );

    }

}
