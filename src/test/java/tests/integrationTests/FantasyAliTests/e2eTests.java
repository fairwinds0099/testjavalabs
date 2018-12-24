package tests.integrationTests.FantasyAliTests;

import com.google.gson.Gson;
import domain.Pojos.PojoRep;
import domain.pages.DirectoryPage;
import org.junit.Test;
import tests.uiTests.UITestBase;
import utils.DaoHelper;
import utils.FileHelpers;
import utils.ServerConfig;


public class e2eTests extends UITestBase {

    ServerConfig rdsAws = ServerConfig.getConfiguration()
            .withHostName("california.cunkqhyctdk7.us-east-1.rds.amazonaws.com")
            .withPort(1521)
            .withDbName("orcl")
            .withUserName("orangecounty")
            .withPassword("Ebru1980)")
            .build();
    FileHelpers fileHelpers = new FileHelpers();
    String query = fileHelpers.getFileContent("insertName.sql");
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
}
