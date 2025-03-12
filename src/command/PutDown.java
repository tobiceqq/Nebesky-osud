package command;

import world.Item;

public class PutDown implements Command {

    private Item item;
    private Backpack inventory;

    public PutDown(Item item, Backpack inventory) {
        this.item = item;
        this.inventory = inventory;
    }

    public String execute() {
        if (item == null) return "There is nothing to put down.";
        if (inventory == null) return "Error: No inventory found.";

        if (inventory.removeItem(item)) {
            return "You put down " + item.getName();
        }
        return "Item is not in the inventory";
    }

    public boolean exit() {
        return false;
    }
}
