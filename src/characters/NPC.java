package characters;

import command.Backpack;
import world.Item;

import java.util.HashMap;

/**
 * Represents a non-player character (NPC) in the game.
 * Each NPC has a name, a dialogue line, and can be assigned to a location.
 */
public class NPC {

    private String name;
    private String dialogue;
    private static HashMap<Integer, NPC> npcs = new HashMap<>();

    public NPC(String name, String dialogue) {
        this.name = name;
        this.dialogue = dialogue;
    }

    /**
     * Registers an NPC at a specific location.
     *
     * @param location the location ID
     * @param npc the NPC instance to assign
     */
    public static void addNPC(int location, NPC npc) {
        npcs.put(location, npc);
    }

    /**
     * Retrieves the NPC assigned to a given location.
     * @param location the location ID
     * @return the NPC at the location, or null if none exists
     */
    public static NPC getNPCIn(int location) {
        return npcs.get(location);
    }

    /**
     * Returns tne NPC's dialogue in a formatted string.
     * @return a string in the form: "name: dialogue"
     */
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
