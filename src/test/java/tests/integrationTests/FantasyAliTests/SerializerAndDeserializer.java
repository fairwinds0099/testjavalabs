package tests.integrationTests.FantasyAliTests;

import domain.Pojos.PojoRep;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SerializerAndDeserializer {
    @Test
    public void serializeToGsonRepAlabama3() {
        List<String> committeesRepAlabama3 = new ArrayList<>();
        committeesRepAlabama3.add("Agriculture");
        committeesRepAlabama3.add("Armed Services");
        committeesRepAlabama3.add("Homeland Security");
        PojoRep repAlabama3 = new PojoRep();
        repAlabama3.setRownum(3);
        repAlabama3.setDistrict("3rd");
        repAlabama3.setName("Rogers, Mike");
        repAlabama3.setParty("R");
        repAlabama3.setOffice("2184 RHOB");
        repAlabama3.setPhone("(202) 225-3261");
        repAlabama3.setCommittees(committeesRepAlabama3);
    }
}
