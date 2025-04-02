package world;

import characters.NPC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;


/**
 * Represents the full game world map.
 * Handles location loading, player movement, and story-related access logic.
 *
 * @author Michaela Meitnerová
 */
public class WorldMap {
    private static HashMap<Integer, Location> world = new HashMap<>();
    private static int start = 0;
    private static int currentPosition = start;
    public static boolean hasMap = false;
    public static boolean location_available1 = false;
    public static boolean location_available3 = false;
    public static boolean location_available4 = false;
    public static boolean location_available6 = false;
    public static boolean brother_rescued = false;


    /**
     * Loads the world map from a text file.
     * Each line represents a location with its connections.
     *
     * @return true if loading was successful, false otherwise
     */
    public boolean loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/textFiles/map.txt"))) {
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

    /**
     * Returns the current player location as a Location object.
     *
     * @return the current location
     */
    public Location getCurrentPosition1() {
        return world.get(currentPosition);
    }

    /**
     * Returns the current position as an integer (location ID)
     *
     * @return the current location ID
     */
    static public int getCurrentPosition() {
        return currentPosition;
    }

    public HashMap<Integer, Location> getWorld() {
        return world;
    }



    /**
     * Moves the player to a new location based on the given direction.
     * Checks for restrictions like missing item or locked paths.
     *
     * @param direction the desired movement direction (example "north", "s", "e", "west")
     * @return a message indicating the outcome of the movement
     */
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
                    return "❌ Invalid direction. Type only these directions: north (n), south (s), east (e), west (w)";
        }
        int newPosition = world.get(currentPosition).getLocations()[index];
        if (newPosition == -1) {
            return "❌ You can't move in this direction.";
        }

            if (currentPosition == 0 && newPosition == 1 && !location_available1) {

                return "❌ The wind blocks your way. Use the Wind Scroll first.";
            }

            if (currentPosition == 2 && newPosition == 3 && !location_available3) {

                return "❌ The forest whispers: 'You are not ready yet.' (You need the Guardian's Amulet!)";

            }

            if (currentPosition == 3 && newPosition == 4 && !location_available4) {

                return "❌ A violent storm rages ahead. Calm it with the Storm Stone!";
            }

            if (currentPosition == 5 && newPosition == 6 && !location_available6) {

                return "❌ The bridge is broken. Only the Dragon Key can restore the path.";
            }

            if (currentPosition == 6 && newPosition == 7 && !brother_rescued) {

                return "❌ A sacred force blocks the way. Rescue your brother first!";
            }

            currentPosition = newPosition;
            return "✅ You moved to " + world.get(currentPosition).getName();
        }


    public void setWorld(HashMap<Integer, Location> testWorld) {
    }
}