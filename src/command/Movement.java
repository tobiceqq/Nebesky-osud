package command;

import world.Location;
import world.WorldMap;

import java.util.Scanner;

public class Movement implements Command {

    private Scanner sc = new Scanner(System.in);
    private WorldMap world;

    public Movement(WorldMap world) {
        this.world = world;
    }

    public String execute() {
        Location currentLocation = world.getCurrentLocation();
        System.out.println("Current location: " + currentLocation);
        System.out.println("Available directions: North, South, East, West");
        System.out.println("Where do you want to go? -> ");

        String direction = sc.nextLine().trim().toLowerCase();
        int directionIndex = getDirectionIndex(direction);

        if (directionIndex == -1) {
            return "Invalid direction. Try 'north', 'south', 'east', or 'west'";
        }

        boolean moved = world.move(directionIndex);
        if (moved) {
            return "Moved to: " + world.getCurrentLocation().getName();
        } else {
            return "You can't go that way.";
        }
    }

    private int getDirectionIndex(String direction) {
        switch (direction) {
            case "north": return 0;
            case "south": return 1;
            case "east": return 2;
            case "west": return 3;
            default: return -1;
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
