package command;

import world.Item;
import world.ItemCategory;
import world.Location;
import world.WorldMap;

import java.util.ArrayList;

public class Explore implements Command {

    private Location location;
    private WorldMap worldMap = new WorldMap();
    ArrayList<Item> roomItems = new ArrayList<>();

    public Explore(Location location) {
        this.location = location;
    }

    @Override
    public String execute() {
        roomItems();

        if (worldMap.getCurrentPosition1() == null) {
            return "Nowhere to go.";
        }
        return "You are in: " + worldMap.getCurrentPosition1().getName() + ".";
    }

    public void roomItems() {
        WorldMap worldMap1 = new WorldMap();
        int currentPosition = worldMap1.getCurrentPosition();

        ArrayList<Item> items = new ArrayList<>();

        switch (currentPosition) {
            case 0:
                break;

            case 1:
                System.out.println("Available items:");
                items.add(new Item("Wind gate", "To get to other location.", ItemCategory.SCROLL));
                break;

            case 2:
                items.add(new Item("Skibidi", "Sigma boy", ItemCategory.WEAPON));
                break;

            case 3:
                items.add(new Item("ROsta", "loool", ItemCategory.HEAL));
                break;
        }

        for (Item item : items) {

            if (!roomItems.contains(item)) {
                System.out.println("Item was added to your backpack.");
                roomItems.add(item);
                System.out.println(item);
            }
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
