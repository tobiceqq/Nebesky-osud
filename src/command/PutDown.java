package command;

import world.Item;

public class PutDown implements Command {

    private Item item;
    private Backpack inventory;


    public String execute() {
        if (inventory.removeItem(item)) {
            return "You put down " + item.getName();
        }
        return "Item is not in the inventory";
    }

    public boolean exit() {
        return false;
    }
}
