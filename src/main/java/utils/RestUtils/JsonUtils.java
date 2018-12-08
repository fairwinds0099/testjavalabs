package utils.RestUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import utils.FileUtils;

import java.lang.reflect.Type;

public class JsonUtils {

    //ignore GsonBuilder if pretty print not required
    public static String serializeWithGson(Object obj) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(obj);
    }

    //use pretty print sas default
    public static String serializeWithJackson(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        //mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    //ideally json shoudl be coming froim a filepath
    public static <T> T deserializeWithGson(String retrievedJson, Type pojo) {
        FileUtils fileUtils = new FileUtils();
        Gson gson = new Gson();
        return gson.fromJson(retrievedJson, pojo);
    }
}
