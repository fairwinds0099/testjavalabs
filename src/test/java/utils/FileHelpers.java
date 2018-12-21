package utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileHelpers {

    //gets the content of a file in resources folder
    public String getFileContent(String filePath) {
        ClassLoader classLoader = getClass().getClassLoader();
        String retrievedText = null;
        try {
            retrievedText =  IOUtils.toString(classLoader.getResourceAsStream(filePath), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  retrievedText;
    }

    //intents to get the list of queries from a .sql file in resources
    public List<String> getQueriesFromFile(String filepath, String splitter) {
        String query = getFileContent(filepath);
        String queries[] = query.split(splitter);
        List<String> queryList = Arrays.asList(queries);
        System.out.println(queryList);
        return queryList;
    }


}
