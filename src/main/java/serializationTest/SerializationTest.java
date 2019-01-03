package serializationTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

//TODO 1 create a POJo for state put it under domain, put the representatives as a list object in that pojo.
//TODO 1 (list of PojoRepresentatives, Pojo icinde pojo)
//TODO 1 The other element is gonna be the state name
//TODO 2 check feature and restructure yours
//TODO 3 Use assertions

public class SerializationTest{
    ObjectMapper mapper = new ObjectMapper();
    PojoRepresentatives [] repAlabama = new PojoRepresentatives[2];
    PojoStates alabamaState = new PojoStates();
    List <PojoRepresentatives> listAlabamaReps = new ArrayList <> ();

    @Test
    public void serialize () throws JsonProcessingException {
        repAlabama[0] = new PojoRepresentatives();
        repAlabama[1] = new PojoRepresentatives();

        repAlabama[0].setDistrict("1st");
        repAlabama[0].setName("Byrne, Bradley");
        repAlabama[0].setParty("R");

        repAlabama[1].setDistrict("1st");
        repAlabama[1].setName("Sewell, Terri A.");
        repAlabama[1].setParty("D");

        listAlabamaReps.add(repAlabama[0]);
        listAlabamaReps.add(repAlabama[1]);

        alabamaState.setState("Alabama");
        alabamaState.setRepresentatives(listAlabamaReps);

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        System.out.println(mapper.writeValueAsString(alabamaState));
    }

    @Test
    public void deSerialize() throws IOException {
        List<PojoStates> alabamaRep1 = Arrays.asList(mapper.readValue(new File("resources/representativesinfo.json"), PojoStates[].class));
        assertEquals("John, Terri A.", alabamaRep1.get(1).getRepresentatives().get(1).getName());
    }

    @Test
    public void deSerialize2() throws IOException {
        PojoStates alabamaRep1 = mapper.readValue(new File("resources/representativesinfo2.json"), PojoStates.class);
        assertEquals("Byrne, Bradley", alabamaRep1.getRepresentatives().get(0).getName());
    }

}