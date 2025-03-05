package command;

import world.Location;

public class Explore implements Command {

    private Location location;


    public String execute() {
        return location.toString();
    }


    public boolean exit() {
        return false;
    }
}
