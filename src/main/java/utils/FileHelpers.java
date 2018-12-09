package utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class FileHelpers {

    public static String getFileContent(String filePath){
        String retrievedText = null;
        try {
            retrievedText = (String) FileUtils.readFileToString(new File(filePath), "UTF-8");
        } catch (IOException e) {
            //do nothing
        }
        return retrievedText;
    }

    public static List<String> getQueriesFromFile(String filepath, String splitter) {
        String query = FileHelpers.getFileContent(filepath);
        String queries[] = query.split(splitter);
        List<String> queryList = Arrays.asList(queries);
        System.out.println(queryList);
        return queryList;
    }



}
