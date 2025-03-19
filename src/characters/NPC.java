package characters;

import java.util.HashMap;

public class NPC {

    private String name;
    private String dialogue;
    private static HashMap<Integer, NPC> npcs = new HashMap<>();

    public NPC(String name, String dialogue) {
        this.name = name;
        this.dialogue = dialogue;
    }

    public static void addNPC(int location, NPC npc) {
        npcs.put(location, npc);
    }

    public static NPC getNPCIn(int location) {
        return npcs.get(location);
    }

    public String talk() {
        return name + ": " + dialogue;
    }

    public String getDialogue() {
        return dialogue;
    }

    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





}
