package dbUtils;

import org.junit.Test;


import java.sql.PreparedStatement;


public class DbConnectionTest  {
    @Test
    public void aliDbTest() throws java.sql.SQLException, ClassNotFoundException{
        DbUtilities dbUtilities = new DbUtilities();
        dbUtilities.addRepresentatives(18, "CA", "Orange County", "John", "Walters" );
        //public void SqlStatement(){
            //Calender calender = calender.getInstance();
            //java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
    }
}
