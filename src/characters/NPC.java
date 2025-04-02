package characters;

import command.Backpack;
import world.Item;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents a non-player character (NPC) in the game.
 * Each NPC has a name, a dialogue line, and can be assigned to a location.
 */
public class NPC {

    private String name;
    private String dialogue;
    private static ArrayList<NPC> npcs = new ArrayList();



    public NPC(String name, String dialogue) {
        this.name = name;
        this.dialogue = dialogue;
    }

    /**
     * Adds a new NPC to the list of NPCs.
     * @param npc
     */
    public static void addNPC(NPC npc) {
        npcs.add(npc);
    }

    /**
     * Retrieves the NPC assigned to a given location.
     * @param location the location ID
     * @return the NPC at the location, or null if none exists
     */

    /**
     * Returns tne NPC's dialogue in a formatted string.
     * @return a string in the form: "name: dialogue"
     */
    public void talk() {
        System.out.println(name +  ": " + dialogue);
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

    public static ArrayList<NPC> getNpcs() {
        return npcs;
    }
}
