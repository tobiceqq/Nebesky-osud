package command;

import world.Location;

public class Explore implements Command {

    private Location location;

    public Explore(Location location) {
        this.location = location;
    }

    public String execute() {
        if (location == null) {
            return "Unknown location.";
        }

        String description = location.getDescription();
        if (description == null || description.isEmpty()) {
            description = "There is nothing special here.";
        }

        return "You are in: " + location.getName() + ". " + description;
    }


    public boolean exit() {
        return false;
    }
}
