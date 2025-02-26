package world;

import java.util.Arrays;

public class Location {

    private String name;
    private int ID;
    private int[] locations;


    public Location() {
        this.name = "";
        this.ID = -1;
        this.locations = new int[]{-1, -1, -1, -1};
    }

    public Location(String name, int ID, int[] locations) {
        this.name = name;
        this.ID = ID;
        this.locations = new int[4];

        for (int i = 0; i < locations.length; i++) {
            try {
                this.locations[i] = locations[i];
            } catch (NumberFormatException e) {
                this.locations[i] = -1;
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public int getDirection(int index) {
        return (index >= 0 && index < locations.length) ? locations[index] : -1;
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
