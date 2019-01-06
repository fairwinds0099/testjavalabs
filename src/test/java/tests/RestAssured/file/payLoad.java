package tests.RestAssured.file;

public class payLoad {
    public static String payLoad(){
        String pl = "{" +
                "    \"postId\": 2,\n" +
                "    \"id\": 6,\n" +
                "    \"name\": \"alibaba\",\n" +
                "    \"email\": \"kirkharamiler@yilbasi.com\",\n" +
                "    \"body\": \"yeni\\yiliniz\\kutlu\\olsun\"\n" +
                "  }";
        return pl;
    }
}
