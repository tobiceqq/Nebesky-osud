package world;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class WorldMap {

    private HashMap<Integer, Location> world = new HashMap<>();
    private int start = 0;
    private int currentPosition = start;
    private static WorldMap instance;

    public WorldMap() {

    }

    public static WorldMap getInstance() {
        if (instance == null) {
            instance = new WorldMap();
        }
        return instance;
    }

    public boolean loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("world/world_map.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 6) continue;

                int ID = Integer.parseInt(parts[0]);
                String name = parts[1];

                int[] directions = new int[4];
                for (int i = 0; i < 4; i++) {
                    try {
                        directions[i] = Integer.parseInt(parts[i + 2]);
                    } catch (NumberFormatException e) {
                        directions[i] = -1;
                    }
                }

                Location location = new Location(name, ID, directions);
                world.put(ID, location);
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error loading world map" + e.getMessage());
            return false;
        }
    }

    public Location getCurrentLocation() {
        return world.get(currentPosition);
    }

    public boolean move(int direction) {
        int nextID = world.get(currentPosition).getDirection(direction);
        if (nextID != -1 && world.containsKey(nextID)) {
            currentPosition = nextID;
            return true;
        }
        return false;
    }

    public HashMap<Integer, Location> getWorld() {
        return world;
    }
}
