package tests.wsTests;

import domain.Pojos.PojoRep;
import domain.Pojos.PojoState;
import org.junit.Test;
import utils.FileHelpers;
import utils.RestUtils.JsonUtils;

import java.io.File;
import java.util.List;

public class DeSerializationTest {

    FileHelpers fileHelpers = new FileHelpers();

    @Test
    public void deserialize() {

        String retrievedJson = (fileHelpers.getFileContent("src/main/resources/alabamaRepsWithGson.json"));

        PojoState deserializedState = JsonUtils.deserializeWithGson(retrievedJson, PojoState.class);
        System.out.println(deserializedState.getState());

        List<PojoRep> listretrievedReps = deserializedState.getReps();
        PojoRep retrievedRep1 = listretrievedReps.get(0);
        System.out.println(retrievedRep1.getCommittees().toString());
    }
}
