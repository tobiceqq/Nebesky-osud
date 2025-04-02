package command;

import world.Item;
import world.ItemCategory;
import world.Location;
import world.WorldMap;
import characters.NPC;

/**
 * Command that allows the player to talk to an NPC
 * present at their current location.
 */
public class Talk implements Command {

    private NPC character;
    private boolean isAdded = false;

    public Talk() {
        this.character = character;
    }

    /**
     * Executes the talk command.
     * If an NPC is present at the current location, returns their dialogue.
     * Otherwise, informs the player that no one is present.
     *
     * @return a dialogue string or a message indicating nobody is there
     */
    public String execute() {

        int currentLocation = WorldMap.getCurrentPosition();

        switch (currentLocation) {
            case 2:
                NPC.getNpcs().get(0).talk();
                if (!isAdded) {
                    Backpack.addItem(new Item("Guardian's Amulet" , "Allows you to enter Island of Storms safely." , ItemCategory.ACCESS));
                    isAdded = true;
                    WorldMap.location_available3 = true;
                }
                break;
            case 4:
                NPC.getNpcs().get(1).talk();
                WorldMap.brother_rescued = true;
                break;
            default:
                return "❌ Silence... There's no one in sight.";
        }

        return "";
    }


    /**
     * This command does not end the game.
     *
     * @return false
     */
    @Override
    public boolean exit() {
        return false;
    }

}
