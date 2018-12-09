package tests.FantasyAliTests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import domain.Pojos.PojoRep;
import domain.Pojos.PojoState;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SerializeWithGSON {

    List<String> alabamaRep1Committees = new ArrayList<String>();
    List<String> alabamaRep2Committees = new ArrayList<String>();
    List<PojoRep> repsOfAlabama = new ArrayList<PojoRep>();

    @Test
    public void serializeWithGSON() {
        alabamaRep1Committees.add("AS");
        alabamaRep1Committees.add("EW");
        alabamaRep1Committees.add("R");
        alabamaRep2Committees.add("B");
        alabamaRep2Committees.add("OG");
        alabamaRep2Committees.add("Reform");
        alabamaRep2Committees.add("SST");

        PojoRep alabamaRep1 = new PojoRep("Bradley", "(202) 225-4931", alabamaRep1Committees);
        PojoRep alabamaRep2 = new PojoRep("Gary", "(202) 225-4921", alabamaRep2Committees);

        repsOfAlabama.add(alabamaRep1);
        repsOfAlabama.add(alabamaRep2);

        PojoState state = new PojoState("Alabama", repsOfAlabama);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(state);
    }

    @Test
    public void deserializeWithGSON(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = "{\n" +
                "  \"state\": \"Alabama\",\n" +
                "  \"reps\": [\n" +
                "    {\n" +
                "      \"name\": \"Bradley\",\n" +
                "      \"phone\": \"(202) 225-4931\",\n" +
                "      \"committees\": [\n" +
                "        \"AS\",\n" +
                "        \"EW\",\n" +
                "        \"R\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Gary\",\n" +
                "      \"phone\": \"(202) 225-4921\",\n" +
                "      \"committees\": [\n" +
                "        \"B\",\n" +
                "        \"OG\",\n" +
                "        \"Reform\",\n" +
                "        \"SST\"\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        PojoState retrievedState = gson.fromJson(jsonString, PojoState.class);
        System.out.println(retrievedState.getState());
        List<PojoRep> alabamaReps = retrievedState.getReps();
        System.out.println(alabamaReps.get(0).getPhone());

    }
}
