package command;

import world.Item;
import world.Location;
import world.WorldMap;

import java.util.ArrayList;

public class Explore implements Command {

    private Location location;
    ArrayList<Item> itemsInRooms = new ArrayList<>();

    public Explore(Location location) {
        this.location = location;
    }

    public String execute() {

        if (location == null) {
            return "Unknown location.";
        }
        return "You are in: " + location.getName() + ". ";

    }

    public boolean exit() {
        return false;
    }
}
