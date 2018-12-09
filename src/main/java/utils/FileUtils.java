package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUtils {


    public String getFileContent(String filePath) {
        StringBuilder result = new StringBuilder();

        //retrieve the  file from path
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(filePath).getFile());

        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            //do nothing
        }
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            result.append(line);
            scanner.close();
        }
    return result.toString();
    }

}
