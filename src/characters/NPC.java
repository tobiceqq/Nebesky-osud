package characters;

public class NPC {

    private String description;

    public NPC() {
    }

    public NPC(String description) {
        this.description = description;
    }

    public String getDialogue() {
        return "NPC says: " + description;
    }

}
