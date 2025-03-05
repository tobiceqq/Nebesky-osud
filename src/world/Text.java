package world;

import java.util.HashMap;

public class Text {

    private HashMap<String, String> texts;



    public String getText(String key) {
        return texts.getOrDefault(key, "Unknown text");
    }


    public boolean loadTexts(String file) {

        return true;
    }
}
