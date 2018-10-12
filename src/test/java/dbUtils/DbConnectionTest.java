package dbUtils;

import org.junit.Test;


import java.sql.PreparedStatement;


public class DbConnectionTest extends DbConnection {
    @Test
    public void aliDbTest() throws java.sql.SQLException, ClassNotFoundException{
        DbConnection dbConnection = new DbConnection();
        dbConnection.DbConnect();
        //public void SqlStatement(){
            //Calender calender = calender.getInstance();
            //java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
    }
}
