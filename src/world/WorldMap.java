package world;

import characters.NPC;

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
    public static boolean location_available1 = false;
    public static boolean location_available2 = false;
    public static boolean location_available3 = false;
    public static boolean location_available4 = false;
    public static boolean brother_rescued = false;



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

    public Location getCurrentPosition1() {
        return world.get(currentPosition);
    }

    static public int getCurrentPosition() {
        return currentPosition;
    }

    public HashMap<Integer, Location> getWorld() {
        return world;
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
                    return "❌ Invalid direction. Type only these directions: north (n), south (s), east (e), west (w)";
        }
        int newPosition = world.get(currentPosition).getLocations()[index];
        if (newPosition == -1) {
            return "❌ You can't move in this direction.";
        }

            if (currentPosition == 0 && newPosition == 1 && !location_available1) {

                return "❌ The wind blocks your way. Use the Wind Scroll first.";
            }

            if (currentPosition == 2 && newPosition == 3 && !location_available2) {

                return "❌ The forest whispers: 'You are not ready yet.' (You need the Guardian's Amulet!)";

            }

            if (currentPosition == 3 && newPosition == 4 && !location_available3) {

                return "❌ A violent storm rages ahead. Calm it with the Storm Stone!";
            }

            if (currentPosition == 5 && newPosition == 6 && !location_available4) {

                return "❌ The bridge is broken. Only the Dragon Key can restore the path.";
            }

            if (currentPosition == 6 && newPosition == 7 && !brother_rescued) {

                return "❌ A sacred force blocks the way. Rescue your brother first!";
            }

            currentPosition = newPosition;
            return "✅ You moved to " + world.get(currentPosition).getName();
        }


    public void initializeNPC(){
        NPC.addNPC(2, new NPC("Hikari" , "Your spirit is restless… yet there’s a fire within you that cannot be extinguished.\n" +
                "\n" +
                "The path ahead is harsh. The storm will crush those who walk without purpose.\n" +
                "\n" +
                "Take this amulet. It won’t protect you from pain… but it will help you find your way through it.\n" +
                "\n" +
                "(Hikari gives you the Guardian’s Amulet.)"));
    }

}