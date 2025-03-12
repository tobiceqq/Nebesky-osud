package command;

import world.Item;

public class PickUp implements Command {

    private Item item;
    private Backpack inventory;

    public PickUp(Item item, Backpack inventory) {
        this.item = item;
        this.inventory = inventory;
    }

    public String execute() {
        if (item == null) return "There is nothing to pick up.";
        if (inventory == null) return "Error: No inventory found.";

        if (inventory.addItem(item)) {
            return "You picked up " + item.getName();
        }
        return "Inventory is full!";
    }


    public boolean exit() {
        return false;
    }
}
