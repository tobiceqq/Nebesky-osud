package world;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;



public class WorldMap {
    private static HashMap<Integer, Location> world = new HashMap<>();
    private static int start = 0;
    private static int currentPosition = start;
    public static boolean hasMap = false;

    public boolean loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/map.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(",");
                Location location = new Location(
                        lines[1],
                        Integer.parseInt(lines[0]),
                        Arrays.copyOfRange(lines, 2, 6)
                );
                world.put(Integer.valueOf(lines[0]), location);
            }

            return true;
        } catch (IOException e) {
            return false;
        }


    }

    public String move(String direction) {
        int index;
        switch (direction.toLowerCase()) {

            case "north":
                index = 0;
                break;
            case "n":
                index = 0;
                break;

            case "south":
                index = 1;
                break;
            case "s":
                index = 1;
                break;

            case "east":
                index = 2;
                break;
            case "e":
                index = 2;
                break;
            case "west":
                index = 3;
                break;
            case "w":
                index = 3;
                break;
            default:
                    return "Invalid direction. Type only these directions: north (n), south (s), east (e), west (w)";
        }
        int newPosition = world.get(currentPosition).getLocations()[index];
        if (newPosition == -1) {
            return "\uD83D\uDEAB You can't move in this direction.";
        } else {
            currentPosition = newPosition;
            return "You moved to: " + world.get(currentPosition).getName();
        }
    }

    public Location getCurrentPosition1(){
        return world.get(currentPosition);
    }

    static public int getCurrentPosition() {
        return currentPosition;
    }

    public HashMap<Integer, Location> getWorld() {
        return world;
    }

}