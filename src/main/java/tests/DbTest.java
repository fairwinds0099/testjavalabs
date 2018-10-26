package tests;


import org.testng.annotations.Test;
import utils.DbUtils.Dao;

import java.sql.SQLException;

// TODO updated
public class DbTest{

    final String queryCreate = "INSERT INTO ADDRESS (ID, STREETNAME, CITY, ZIPCODE, STATE)" +
            "VALUES(7, '311 True St', 'Richmond', '54544', 'VA')";
    final String queryRead = "SELECT * FROM ADDRESS WHERE ZIPCODE=54544";
    final String queryUpdate = "UPDATE ADDRESS SET CITY = 'Miami', ZIPCODE='22222' WHERE ID='7'";
    final String queryDelete = "DELETE FROM ADDRESS WHERE ID=7";

    @Test
    public void myTest() throws SQLException {

        Dao dao = new Dao();
        dao.createQuery(queryCreate);
        dao.deleteQuery(queryDelete);
        dao.updateQuery(queryUpdate);
        dao.readQuery(queryRead);




    }
}
