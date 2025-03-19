package command;

import world.Item;

import java.util.ArrayList;

public class Use implements Command {

    private Item item;
    ArrayList<Item> items_BranaVetru = new ArrayList<>();
    ArrayList<Item> items_OstrovBilychStinu = new ArrayList<>();
    ArrayList<Item> items_NebeskyLes = new ArrayList<>();
    ArrayList<Item> items_OstrovBouri = new ArrayList<>();
    ArrayList<Item> items_NebeskyHrad = new ArrayList<>();
    ArrayList<Item> items_SvatyneMlznehoDraka = new ArrayList<>();
    ArrayList<Item> items_RozpadlyMost = new ArrayList<>();
    ArrayList<Item> items_PosvatnaSvatyne = new ArrayList<>();


    public Use(Item item) {
        this.item = item;
    }

    public String execute() {
        if (item == null) return "There is nothing to use.";

        String result = item.useItem();
        return (result != null && !result.isEmpty()) ? result : "You used: " + item.getName();
    }

    public void addItem() {
        items_BranaVetru.add(new Item("Wind scroll", "An ancient scroll that controls the power of the wind."));
        items_BranaVetru.add(new Item("Wind scroll", "An ancient scroll that controls the power of the wind."));
        items_BranaVetru.add(new Item("Wind scroll", "An ancient scroll that controls the power of the wind."));
        items_BranaVetru.add(new Item("Wind scroll", "An ancient scroll that controls the power of the wind."));
        items_BranaVetru.add(new Item("Wind scroll", "An ancient scroll that controls the power of the wind."));
        items_BranaVetru.add(new Item("Wind scroll", "An ancient scroll that controls the power of the wind."));
        items_BranaVetru.add(new Item("Wind scroll", "An ancient scroll that controls the power of the wind."));
        items_BranaVetru.add(new Item("Wind scroll", "An ancient scroll that controls the power of the wind."));
    }

    public boolean exit() {
        return false;
    }
}
