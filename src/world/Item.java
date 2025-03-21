package world;

public class Item {

    private String name;
    private String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }


    public String useItem() {
        return "You used" + name + ", but nothing happened.";
    }

    @Override
    public String toString() {
        return name + " - " + description;
    }
}
