package tests;


import org.testng.annotations.Test;
import utils.DbUtils.Dao;

import java.sql.SQLException;

// TODO updated
public class DbTest{


    @Test
    public void myTest() throws SQLException {

        Dao dbCon = new Dao();
        dbCon.createQuery();
        dbCon.deleteQuery();
        dbCon.updateQuery();
        dbCon.readQuery();




    }
}
