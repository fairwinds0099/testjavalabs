package tests.dbTests;

import domain.Pojos.PojoRep;
import org.junit.Test;
import utils.DaoHelper;
import utils.FileHelpers;
import utils.ServerConfig;

import java.util.ArrayList;
import java.util.List;

public class DbTestWithBuilder {

        ServerConfig rdsAws = ServerConfig.getConfiguration()
                .withHostName("california.cunkqhyctdk7.us-east-1.rds.amazonaws.com")
                .withPort(1521)
                .withDbName("orcl")
                .withUserName("orangecounty")
                .withPassword("Ebru1980)")
                .build();


    FileHelpers fileHelpers = new FileHelpers();
    String query = fileHelpers.getFileContent("insertReps.sql");
    //String query = "INSERT INTO REPRESENTATIVES (ROWNUMBER, DISTRICT, NAME, PARTY, OFFICE_ROOM, PHONE, COMMITTEE_ASSIGNMENT) VALUES (2, '2nd', 'Roby, Martha', 'R', '442 CHOB', '(222) 225-2901', 'Appropriations'), (2, '2nd', 'Roby, Martha', 'R', '442 CHOB', '(222) 225-2901', 'Judiciary');";
    @Test
    public void myTest() throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        DaoHelper.runSqlQuery(rdsAws, query);
    }

    @Test
    public void dbTestRepresentatives () {


    }
}
