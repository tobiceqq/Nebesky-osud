package command;

import world.Item;

import java.util.List;

public class Backpack {
    private List<Item> items;
    private int capacity;



    public boolean addItem(Item item) {
        if (items.size() < capacity) {
            items.add(item);
            return true;
        }
        return false;
    }

    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    public boolean hasItem(String itemName) {
        return items.stream().anyMatch(i -> i.getName().equals(itemName));
    }

    public List<Item> getItems() {
        return items;
    }

    public String useItem() {
        return "Item used";
    }

    public boolean isFull() {
        return items.size() >= capacity;
    }

    @Override
    public String toString() {
        return "Inventory: " + items.toString();
    }
}
