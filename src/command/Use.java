package command;

import world.Item;

public class Use implements Command {

    private Item item;

    public String execute() {
        return "You used: " + item.getName();
    }

    public boolean exit() {
        return false;
    }
}
