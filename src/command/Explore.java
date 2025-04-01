package command;

import world.Item;
import world.ItemCategory;
import world.Location;
import world.WorldMap;

import java.util.ArrayList;
import java.util.HashMap;

public class Explore implements Command {

    private WorldMap worldMap = new WorldMap();
    private Location location;
    private HashMap<Integer, ArrayList<Item>> roomItems = new HashMap<>();

    public Explore(Location location) {
        this.location = location;
    }

    public String execute() {

        System.out.println("\uD83C\uDF0D Your current location is: " + worldMap.getCurrentPosition1() + ".");
        AvailableItems();

        if (worldMap.getCurrentPosition1() == null) {
            return "This place doesn't exist...";
        }
        return "";
    }

    public void AvailableItems() {
        int currentPosition = WorldMap.getCurrentPosition();
        if (!roomItems.containsKey(currentPosition)) {
            ArrayList<Item> items = new ArrayList<>();

            switch (currentPosition) {
                case 0:
                    items.add(new Item("Wind Scroll" , "Allows the access to the next area" , ItemCategory.ACCESS));
                    WorldMap.location_available1 = true;
                    break;
                case 1:
                    items.add(new Item("Silver Bell" , "" , ItemCategory.ACCESS));
                    break;
                case 2:
                    items.add(new Item("Guardian's Amulet" , "" , ItemCategory.ACCESS));
                    items.add(new Item("Heal potion" , "Heals you by 15 HP" , ItemCategory.HEAL));
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

    @Override
    public boolean exit() {
        return false;
    }
}
