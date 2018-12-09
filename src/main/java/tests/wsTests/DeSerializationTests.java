package tests.wsTests;

import domain.Pojos.PojoRep;
import domain.Pojos.PojoState;
import org.junit.Test;
import utils.FileHelpers;
import utils.RestUtils.JsonUtils;

import java.util.List;

public class DeSerializationTests {

    @Test
    public void deserialize() {

        String retrievedJson = (FileHelpers.getFileContent("resources/alabamaRepsWithGson.json"));

        PojoState deserializedState = JsonUtils.deserializeWithGson(retrievedJson, PojoState.class);
        System.out.println(deserializedState.getState());

        List<PojoRep> listretrievedReps = deserializedState.getReps();
        PojoRep retrievedRep1 = listretrievedReps.get(0);
        System.out.println(retrievedRep1.getCommittees().toString());
    }
}
