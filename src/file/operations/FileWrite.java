package file.operations;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

// Class to write txt file as String Lines
public class FileWrite {
    public static void writeFile(String filePath, List<String> content) {
        try {
            // Open the output file for writing
            OutputStream outputStream = new FileOutputStream(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));

            // Write the content to the output file
            for (String line : content) {
                bufferedWriter.write(line);
                bufferedWriter.newLine(); // Write a new line after each line
            }

            // Close the output stream
            bufferedWriter.close();
            System.out.println("File written successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
