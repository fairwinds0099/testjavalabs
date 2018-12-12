package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

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
}
