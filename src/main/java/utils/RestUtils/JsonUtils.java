package utils.RestUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

public class JsonUtils {

    //ignore GsonBuilder if pretty print not required
    public static String serializeWithGson(Object obj) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(obj);
    }

    //use pretty print as default
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

    public static <T> T deserializeWithGson(String retrievedJson, Type pojoClass) {
        Gson gson = new Gson();
        return gson.fromJson(retrievedJson, pojoClass);
    }
}
