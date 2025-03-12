package characters;

public class Brother extends NPC {

    private boolean isRescued;

    public Brother(String name, String description) {
        super(name, description);
        this.isRescued = false;
    }

    public void rescue() {
        if (!isRescued) {
            isRescued = true;
            System.out.println(getName() + " has been rescued!");
        } else {
            System.out.println(getName() + " is already safe.");
        }
    }

    public boolean isRescued() {
        return isRescued;
    }
}
