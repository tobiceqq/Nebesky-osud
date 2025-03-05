package command;

import world.Item;

public class PickUp implements Command {

    private Item item;
    private Backpack inventory;


    public String execute() {
        if (inventory.addItem(item)) {
            return "You picked up " + item.getName();
        }
        return "Inventory is full!";
    }


    public boolean exit() {
        return false;
    }
}
