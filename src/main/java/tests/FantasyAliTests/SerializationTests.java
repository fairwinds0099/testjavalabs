package tests.FantasyAliTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import domain.Pojos.PojoState;
import domain.Pojos.PojoRep;
import org.junit.Test;
import utils.FileUtils;
import utils.RestUtils.JsonUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        objRepAlabama1.setParty("R");
        objRepAlabama1.setCommittees(listCommitteesRepAlabama1);

        // fill alabamaState info
        objRepAlabama2.setName("Terri Sewell");
        objRepAlabama2.setParty("D");
        objRepAlabama2.setCommittees(listCommitteesRepAlabama2);

        //make the list of Rep Objects each object corresponds to a line in the table
        listObjAlabamaReps.add(objRepAlabama1);
        listObjAlabamaReps.add(objRepAlabama2);

        objAlabamaReps.setState("Alabama");
        objAlabamaReps.setReps(listObjAlabamaReps);

        //System.out.println(serializeWithGson(objAlabamaReps));
        System.out.println(serializeWithJackson(objAlabamaReps));
    }


    @Test
    public void deserialize(){

    PojoState deserializedState = deserializeWithGson("{\n" +
            "  \"state\": \"Alabama\",\n" +
            "  \"reps\": [\n" +
            "    {\n" +
            "      \"name\": \"Bradley Byrene\",\n" +
            "      \"party\": \"R\",\n" +
            "      \"committees\": [\n" +
            "        \"AS\",\n" +
            "        \"EW\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Terri Sewell\",\n" +
            "      \"party\": \"D\",\n" +
            "      \"committees\": [\n" +
            "        \"Intel\",\n" +
            "        \"ways and means\"\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}", PojoState.class);
        System.out.println(deserializedState.getState());
        List<PojoRep> listretrievedReps = deserializedState.getReps();
        PojoRep retrievedRep1 = listretrievedReps.get(0);
        System.out.println(retrievedRep1.getCommittees().toString());
    }

    //Below methods to be moved to JsonUtils or RestUtils


    //ignore GsonBuilder if pretty print not required
    private String serializeWithGson(Object obj) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(obj);
    }

    //use pretty print sas default
    private String serializeWithJackson(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    //filepath is where the json string resides
    private <T> T deserializeWithGson(String json, Type pojo) {
        Gson gson = new Gson();
        return gson.fromJson(json, pojo);
    }

   
}
