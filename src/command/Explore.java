package command;

import characters.Brother;
import characters.Player;
import world.Item;
import world.ItemCategory;
import world.Location;
import world.WorldMap;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Command that allows the player to explore their current location.
 * Reveals and collects available items based on the location ID.
 */
public class Explore implements Command {

    private WorldMap worldMap = new WorldMap();
    private Location location;
    private HashMap<Integer, ArrayList<Item>> roomItems = new HashMap<>();

    public Explore(Location location) {
        this.location = location;
    }

    /**
     * Executes the explore command: displays the current location and collects any available items for that position.
     *
     * @return a message if the location is invalid, otherwise an empty string
     */
    public String execute() {

        System.out.println("\uD83C\uDF0D Your current location is: " + worldMap.getCurrentPosition1() + ".");
        AvailableItems();

        if (worldMap.getCurrentPosition1() == null) {
            return "This place doesn't exist...";
        }
        return "";
    }

    /**
     * Checks for and provides items based on the player's current location.
     * Items are added to the backpack and removed from the room once collected.
     */
    public void AvailableItems() {
        int currentPosition = WorldMap.getCurrentPosition();
        if (!roomItems.containsKey(currentPosition)) {
            ArrayList<Item> items = new ArrayList<>();

            switch (currentPosition) {
                case 0:
                    items.add(new Item("Wind Scroll" , "Unlocks access to Island of White Shadows from Wind Gate." , ItemCategory.ACCESS));
                    WorldMap.location_available1 = true;
                    break;
                case 1:
                    break;
                case 2:
                    items.add(new Item("Guardian's Amulet" , "Allows you to enter Island of Storms safely." , ItemCategory.ACCESS));
                    items.add(new Item("Healing Herb" , "Restores +20 HP when used." , ItemCategory.HEAL));
                    WorldMap.location_available3 = true;
                    break;
                case 3:
                    items.add(new Item("Soul Key" , "Opens the spiritual gate leading to Sky Castle." , ItemCategory.ACCESS));
                    WorldMap.location_available3 = true;
                    break;
                case 4:
                    items.add(new Item("Storm Stone" , "Calms the storm and unlocks access to Sky Castle." , ItemCategory.ACCESS));
                    items.add(new Item("Power Gem" , "Increases your damage by +10 permanently." , ItemCategory.HEAL));
                    WorldMap.location_available3 = true;
                    break;
                case 5:
                    items.add(new Item("Healing Herb" , "Restores +20 HP when used." , ItemCategory.POWER));
                    break;
                case 6:
                    items.add(new Item("Dragon Key" , "Rebuilds the broken bridge to reach the Sacred Shrine." , ItemCategory.POWER));
                    items.add(new Item("Power Gem" , "Increases your damage by +10 permanently." , ItemCategory.HEAL));
                    break;
                case 7:
                    WorldMap.brother_rescued = true;
                    break;

            }
            roomItems.put(currentPosition, items);
        }

        ArrayList<Item> items = roomItems.get(currentPosition);

        if (items != null && !items.isEmpty()) {
            for (Item item : new ArrayList<>(items)) {
                Backpack.addItem(item);
                System.out.println("✅ " + item + " has been added to your inventory.");
            }
            items.clear();
        } else {
            System.out.println("❌ No more items here.");
        }
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
