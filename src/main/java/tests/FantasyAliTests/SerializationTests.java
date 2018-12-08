package tests.FantasyAliTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import domain.Pojos.PojoAllState;
import domain.Pojos.PojoReps;
import org.junit.Test;
import utils.FileUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SerializationTests {

    PojoReps repAlabama1 = new PojoReps();
    PojoReps repAlabama2 = new PojoReps();
    PojoAllState alabamaState = new PojoAllState();
    List<PojoReps> listAlabamaReps = new ArrayList<PojoReps>();

    @Test
    public void serialize() {

        //fill repAlabama1 info
        repAlabama1.setName("Tony");
        repAlabama1.setParty("D");
        //fill repAlabama2 info
        repAlabama2.setName("Jane");
        repAlabama2.setParty("R");
        //make a list fo alabamaReps
        listAlabamaReps.add(repAlabama1);
        listAlabamaReps.add(repAlabama2);

        // fill alabamaState info
        alabamaState.setState("Alabama");
        alabamaState.setReps(listAlabamaReps);

        System.out.println(serializeWithGson(alabamaState));

        System.out.println(serializeWithJackson(alabamaState));
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
        //mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    //filepath is where the json string resides
    private <T> T deserializeWithGson(String filePath, Type pojo) {
        FileUtils fileUtils = new FileUtils();
        String retrievedJson = fileUtils.getFileContent(filePath);
        Gson gson = new Gson();
        return gson.fromJson(retrievedJson, pojo);
    }
}
