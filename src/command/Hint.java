package command;

import world.Location;

public class Hint implements Command {

    private Location location;


    public String execute() {
        return "Hint for the loction: " + location.getDescription();
    }


    public boolean exit() {
        return false;
    }
}
