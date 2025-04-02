package world;
import java.util.Arrays;

/**
 * Represents a location in the game world.
 */
public class Location {
    private String name;
    private int ID;
    private int[] locations;

    public Location(){

    }

    public Location(String name, int ID, String[] locations) {
        this.name = name;
        this.ID = ID;
        this.locations = new int[4];
        for (int i = 0; i < locations.length; i++) {
            this.locations[i] = Integer.parseInt(locations[i]);
        }
    }

    public Location(String name, int ID, int[] locations) {
        this.name = name;
        this.ID = ID;
        this.locations = locations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int[] getLocations() {
        return locations;
    }

    public void setLocations(int[] locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return name + ", ID: " + ID + ", locations: " + Arrays.toString(locations);
    }
}