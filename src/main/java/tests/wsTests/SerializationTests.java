package tests.wsTests;

import domain.Pojos.PojoRep;
import domain.Pojos.PojoState;
import org.junit.Test;
import utils.RestUtils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

public class SerializationTests {

    PojoRep objRepAlabama1 = new PojoRep();
    PojoRep objRepAlabama2 = new PojoRep();
    PojoState objAlabamaReps = new PojoState();

    List<String> listCommitteesRepAlabama1 = new ArrayList<String>();
    List<String> listCommitteesRepAlabama2 = new ArrayList<String>();

    List<PojoRep> listObjAlabamaReps = new ArrayList<PojoRep>();

    @Test
    public void serialize() {
        listCommitteesRepAlabama1.add("AS");
        listCommitteesRepAlabama1.add("EW");

        listCommitteesRepAlabama2.add("Intel");
        listCommitteesRepAlabama2.add("ways and means");

        //fill objRepAlabama1 info
        objRepAlabama1.setName("Bradley Byrene");
        //objRepAlabama1.setParty("R");
        //objRepAlabama1.setCommittees(listCommitteesRepAlabama1);

        // fill alabamaState info
        objRepAlabama2.setName("Terri Sewell");
        objRepAlabama2.setParty("D");
        objRepAlabama2.setCommittees(listCommitteesRepAlabama2);

        //make the list of Rep Objects each object corresponds to a line in the table
        listObjAlabamaReps.add(objRepAlabama1);
        listObjAlabamaReps.add(objRepAlabama2);

        objAlabamaReps.setState("Alabama");
        objAlabamaReps.setReps(listObjAlabamaReps);

        System.out.println(JsonUtils.serializeWithJackson(objAlabamaReps));

        System.out.println(JsonUtils.serializeWithGson(objAlabamaReps));
    }

}
