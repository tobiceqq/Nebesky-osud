package world;

import java.util.Arrays;

public class Location {

    private String name;
    private String description;
    private int ID;
    private int[] locations;
    private String hint;


    public Location() {
        this.name = "";
        this.ID = -1;
        this.locations = new int[]{-1, -1, -1, -1};
        this.hint = "";
    }

    public Location(String name, String description, int ID, int[] locations, String hint) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.locations = new int[4];
        this.hint = hint;

        for (int i = 0; i < locations.length; i++) {
            try {
                this.locations[i] = locations[i];
            } catch (NumberFormatException e) {
                this.locations[i] = -1;
            }
        }
    }

    public Location(String name, int id, int[] directions) {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        if (description == null || description.trim().isEmpty()) {
            return "There is nothing special here.";
        }
        return description;
    }

    public int getID() {
        return ID;
    }

    public int getDirection(int index) {
        return (index >= 0 && index < locations.length) ? locations[index] : -1;
    }

    public String getHint() {
        return (hint != null && !hint.isEmpty()) ? hint : "No hint available for this location";
    }

    @Override
    public String toString() {
        return "world.Location{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", locations=" + Arrays.toString(locations) +
                '}';
    }
}
