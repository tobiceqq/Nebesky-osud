package world;

public class Item {

    private String name;
    private String description;
    private boolean isPortable;

    public Item(String name, String description, boolean isPortable) {
        this.name = name;
        this.description = description;
        this.isPortable = isPortable;
    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }


    public boolean isPortable() {
        return isPortable;
    }

    public String useItem() {
        return "You used" + name + ", but nothing happened.";
    }

    @Override
    public String toString() {
        return name + " - " + description;
    }
}
