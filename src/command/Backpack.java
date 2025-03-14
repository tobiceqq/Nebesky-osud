package command;

import world.Item;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private List<Item> items;
    private int capacity;

    public Backpack(int capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

    public boolean addItem(Item item) {
        if (item == null) return false;
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
        return new ArrayList<>(items);
    }

    public String useItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                items.remove(item);
                return item.useItem();
            }
        }
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
