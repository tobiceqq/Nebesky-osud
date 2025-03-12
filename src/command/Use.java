package command;

import world.Item;

public class Use implements Command {

    private Item item;

    public Use(Item item) {
        this.item = item;
    }

    public String execute() {
        if (item == null) return "There is nothing to use.";

        String result = item.useItem();
        return (result != null && !result.isEmpty()) ? result : "You used: " + item.getName();
    }

    public boolean exit() {
        return false;
    }
}
