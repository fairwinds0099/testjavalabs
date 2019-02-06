package utils.RestUtils.Gov.House;

import org.junit.Test;
import utils.RestUtils.JsonUtils;

public class sampleHouseObj extends JsonUtils {
    RepBuilder repBuilder = new RepBuilder.Builder ("48th", "Jacob Brendall", "R").setCommitte("education").setOfficeRoom("110CHOB").setPhone("212-343 7385").build();
    @Test
    public void sample(){
        System.out.println(serializeWithGson(repBuilder));
    }
}
