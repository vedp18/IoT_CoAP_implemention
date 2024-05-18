import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.californium.core.CoapResponse;

public class ForFile {
    public static void main(String[] args) {
        // Path to the file
        String filePath = "C:\\Users\\Monk\\Desktop\\IoT_CoAP_implemention-main\\coap\\data\\2K.txt";

        // Read the file content into a String and print it
        try {
            String fileContent = readFileAsString(filePath);
            System.out.println(fileContent); // This line prints the content to the terminal
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFileAsString(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readString(path);
    }

    public static void convertResponseToFile(CoapResponse response, String filePath) {
        // Get payload from the response
        String payload = response.getResponseText();

        // Write payload to text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(payload);
            System.out.println("Response written to file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}