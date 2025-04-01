package world;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Text {

    private String fielPath;

    public Text(String fielPath) {
        this.fielPath = fielPath;
    }

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
