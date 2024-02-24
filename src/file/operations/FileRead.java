package file.operations;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

// Class to read File as String Lines
public class FileRead {
    public static List<String> readFile(String filePath) {
        try {
            // Open the input file for reading
            InputStream inputStream = new FileInputStream(filePath);
            return new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines().collect(Collectors.toList());

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
