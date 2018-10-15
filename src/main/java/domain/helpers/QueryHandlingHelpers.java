package domain.helpers;

import domain.DbSingleton;
import domain.Pojos.Address;
import domain.Pojos.Representatives;
import domain.enums.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryHandlingHelpers {

       private DbSingleton instance = DbSingleton.getInstance();
       private Connection connection = instance.getConnection();

       protected Representatives findRepresentative(String repId){
              Representatives rep = new Representatives();
              try (PreparedStatement statement = connection.prepareStatement(Query.REPBYID.getQuery())){
                     statement.setString(1,repId);
                     ResultSet resultSet = statement.executeQuery();
                     while (resultSet.next()){
                            rep.setFirstName(resultSet.getString("CITY"));
                     }
              } catch (SQLException e) {
                     e.printStackTrace();
              }
              return rep;
       }

       public Address findAddress(String id){
              Address address = new Address();
              try (PreparedStatement statement = connection.prepareStatement(Query.SEARCHBYSTATE.getQuery())){
                     statement.setString(1,id);
                     ResultSet resultSet = statement.executeQuery();
                     while (resultSet.next()){
                            address.setState(resultSet.getString("STATE"));
                     }
              } catch (SQLException e) {
                     e.printStackTrace();
              }
              return address;
       }
}
