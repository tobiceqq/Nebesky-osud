package world;

import java.util.Random;

/**
 * Represents an item in the game world.
 * Each item has a name, description, category and may provide boost.
 */
public class Item {

    Random random = new Random();
    private String name;
    private String description;
    private int damageBoost = random.nextInt(10, 15);
    private int hpBoost = random.nextInt(15, 25);
    private ItemCategory category;

    public Item(String name, String description, ItemCategory category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDamageBoost() {
        return damageBoost;
    }

    public int getHpBoost() {
        return hpBoost;
    }

    public ItemCategory getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Item → " + "name: " + name + " | description: " + description + " | category: " + category;
    }
}
