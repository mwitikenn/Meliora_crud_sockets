package tech.meliora.training.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author kamochu
 */
public class FileUtils {

    private final static String ROOT_DIRECTORY = "www";

    /**
     * checks if the file or resource exists
     *
     * @param resource resource relative to the root directory
     * @return true if exists, false if file does not exist
     */
    public static boolean fileExists(String resource) {

        File tmpDir = new File(ROOT_DIRECTORY + "/" + resource);
        boolean exists = tmpDir.exists();

        return exists;

    }

    /**
     * reads the content of the file and returns content as a string
     *
     * @param resource file path relative to the root directory
     * @return content of the file read
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String readFile(String resource) throws FileNotFoundException, IOException {

        BufferedReader objReader = null;

        String strCurrentLine;
        String content = "";

        objReader = new BufferedReader(new FileReader(ROOT_DIRECTORY + "/" + resource));

        while ((strCurrentLine = objReader.readLine()) != null) {

            content += strCurrentLine;
        }

        return content;

    }

    /**
     * get the extension of a file
     *
     * @param resource path to the file or filename
     * @return extension returns css if file is main.css
     */
    public static String getExtension(String resource) {
        String extension = null;
        int i = resource.lastIndexOf('.');
        if (i > 0) {
            extension = resource.substring(i + 1);
        }

        return extension;

    }

}
