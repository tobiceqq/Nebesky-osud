package command;

import world.Location;

public class Hint implements Command {

    private Location location;

    public Hint(Location location) {
        this.location = location;
    }

    public String execute() {
        if (location == null) return "You seem to be lost... No hint available.";

        String hint = location.getHint();
        return (hint != null && !hint.isEmpty()) ? hint : "There are no hints for this place.";
    }

    public boolean exit() {
        return false;
    }
}
