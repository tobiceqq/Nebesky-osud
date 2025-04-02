package world;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Utility class used to load and return the contents of a text file.
 */
public class Text {

    private String fielPath;

    public Text(String fielPath) {
        this.fielPath = fielPath;
    }

    /**
     * Reads the contents of the specified file line by line and returns it as a string.
     *
     * @return the full contents of the text file, or an error message if loading fails
     */
    public String startText() {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(fielPath))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }

        } catch (IOException e) {
            return "❌ Failed to load file: " + fielPath;
        }

        return sb.toString();

    }
}
