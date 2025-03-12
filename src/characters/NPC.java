package characters;

public class NPC {

    private static NPC instance;
    private String name;
    private String description;


    public NPC() {
    }

    public NPC(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static NPC getInstance() {
        if (instance == null) {
            instance = new NPC();
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public String getDialogue() {
        return "This character has no words.";
    }
}
