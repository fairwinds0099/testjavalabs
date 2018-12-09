package domain.Pojos;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class RepresentativesAdapter extends TypeAdapter<Representatives> {
    @Override
    public void write(JsonWriter jsonWriter, Representatives representatives) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("name");
        jsonWriter.value(representatives.getName());
        jsonWriter.name("committee_assignment_is_null");
        jsonWriter.value(representatives.getCommittee_assignment());
        jsonWriter.name("phoneNumber");
        jsonWriter.value(representatives.getParty());
        jsonWriter.endObject();
    }

    @Override
    public Representatives read (JsonReader jsonReader) throws IOException {
        Representatives representatives = new Representatives();
        jsonReader.beginObject();
        String fieldname = null;

        while(jsonReader.hasNext()){
            JsonToken token =  jsonReader.peek();
            if(token.equals(JsonToken.NAME)){
                fieldname = jsonReader.nextName();
            }
            if("nickname".equals(fieldname)){
                token = jsonReader.peek();
                representatives.setName(jsonReader.nextString());
            }
            if("committee_assignment_is_null".equals(fieldname)){
                token = jsonReader.peek();
                representatives.setCommittee_assignment(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return representatives;
    }
}
