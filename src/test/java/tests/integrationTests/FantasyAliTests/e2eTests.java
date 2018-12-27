package tests.integrationTests.FantasyAliTests;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import domain.Pojos.PojoRep;
import domain.pages.DirectoryPage;
import org.junit.Test;
import tests.uiTests.UITestBase;
import utils.DaoHelper;
import utils.FileHelpers;
import utils.ServerConfig;

import java.sql.SQLException;
import java.util.List;

import static javax.swing.UIManager.get;


public class e2eTests extends UITestBase {

    ServerConfig rdsAws = ServerConfig.getConfiguration()
            .withHostName("california.cunkqhyctdk7.us-east-1.rds.amazonaws.com")
            .withPort(1521)
            .withDbName("orcl")
            .withUserName("orangecounty")
            .withPassword("Ebru1980)")
            .build();
    FileHelpers fileHelpers = new FileHelpers();
    String query = fileHelpers.getFileContent("insertReps.sql");
    String sqlQuery = fileHelpers.getFileContent("selectReps.sql");
    String jsonString;

    //TODO
    @Test
    public void alabamaRepNameShouldBeMappedToObject(){
        homePage.clickRepresentativesLink();
        PojoRep alabamaRep1 = new PojoRep();
        alabamaRep1.setName(DirectoryPage.getFirstRepNameForAlabama());
        System.out.println(alabamaRep1.getName());
    }

    //TODO
    @Test
    public void alabamaRepNameShouldBeMappedAndSerialized() {
        homePage.clickRepresentativesLink();
        PojoRep alabamaRep1 = new PojoRep();
        alabamaRep1.setName(DirectoryPage.getFirstRepNameForAlabama());
        Gson gson = new Gson();
        String jsonString = gson.toJson("Byrne, Bradley");
        System.out.println(jsonString);
    }

    //TODO
    @Test
    public void serializedAlabamaRepNameShouldBeDeSerizalized() {
        homePage.clickRepresentativesLink();
        PojoRep alabamaRep1 = new PojoRep();
        alabamaRep1.setName(DirectoryPage.getFirstRepNameForAlabama());
        Gson gson = new Gson();
        String jsonString = gson.toJson(alabamaRep1);
        PojoRep alabamaRep1Name = gson.fromJson(jsonString, PojoRep.class);
        System.out.println(alabamaRep1Name.getName());
    }

    //TODO
    @Test
    public void serializedAlabamaRepNameShouldBeDeSerizalizedAndSentoDb()  throws ClassNotFoundException {
        homePage.clickRepresentativesLink();
        PojoRep alabamaRep1 = new PojoRep();
        alabamaRep1.setName(DirectoryPage.getFirstRepNameForAlabama());
        Gson gson = new Gson();
        String jsonString = gson.toJson(alabamaRep1);
        PojoRep alabamaRep1Name = gson.fromJson(jsonString, PojoRep.class);
        Class.forName("oracle.jdbc.driver.OracleDriver");
        DaoHelper.runSqlQuery(rdsAws, String.format(query, alabamaRep1Name.getName()));
    }

    @Test
    public void deserializedAlabamaRepsNameShouldMatchWithUI() throws SQLException, ClassNotFoundException {

        PojoRep alabamaRep1 = new PojoRep();
        PojoRep alabamaRep2 = new PojoRep();
        Class.forName("oracle.jdbc.driver.OracleDriver");
        alabamaRep1.setName(DaoHelper.getAllRecordsForColumn(rdsAws, sqlQuery, "NAME").get(0));
        alabamaRep1.setPhone(DaoHelper.getAllRecordsForColumn(rdsAws, sqlQuery, "PHONE").get(0));
        alabamaRep1.setOffice(DaoHelper.getAllRecordsForColumn(rdsAws, sqlQuery, "OFFICE_ROOM").get(0));
        alabamaRep1.setParty(DaoHelper.getAllRecordsForColumn(rdsAws, sqlQuery, "PARTY").get(0));
        alabamaRep1.setRownum(Integer.parseInt(DaoHelper.getAllRecordsForColumn(rdsAws, sqlQuery, "ROWNUMBER").get(0)));
        alabamaRep2.setName(DaoHelper.getAllRecordsForColumn(rdsAws, sqlQuery, "NAME").get(1));
        alabamaRep2.setPhone(DaoHelper.getAllRecordsForColumn(rdsAws, sqlQuery, "PHONE").get(1));
        alabamaRep2.setOffice(DaoHelper.getAllRecordsForColumn(rdsAws, sqlQuery, "OFFICE_ROOM").get(1));
        alabamaRep2.setParty(DaoHelper.getAllRecordsForColumn(rdsAws, sqlQuery, "PARTY").get(1));
        alabamaRep2.setRownum(Integer.parseInt(DaoHelper.getAllRecordsForColumn(rdsAws, sqlQuery, "ROWNUMBER").get(1)));
        Gson gson = new Gson();
        String jsonString = gson.toJson(alabamaRep1);
        PojoRep repAlabama = gson.fromJson(jsonString, PojoRep.class);
        System.out.println(repAlabama.getName());
        //Class.forName("oracle.jdbc.driver.OracleDriver");
        //System.out.println(DaoHelper.getAllRecordsForColumn(rdsAws, "Select * from Representatives", "NAME").get(0));*/
    }
}
