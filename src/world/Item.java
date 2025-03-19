package world;

public class Item {

    private String name;
    private String description;
    private int damageBoost;
    private int hpBoost;
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
        return "Item → " + "name: " + name + ", description: " + description + ", category: " + category;
    }
}
