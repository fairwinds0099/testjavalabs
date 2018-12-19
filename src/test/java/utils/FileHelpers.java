package utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileHelpers {

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

    public List<String> getQueriesFromFile(String filepath, String splitter) {
        String query = getFileContent(filepath);
        String queries[] = query.split(splitter);
        List<String> queryList = Arrays.asList(queries);
        System.out.println(queryList);
        return queryList;
    }
}
