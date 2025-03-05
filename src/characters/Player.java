package characters;

public class Player {

    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void interact() {

    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
