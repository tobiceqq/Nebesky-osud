package command;

public class Help implements Command {


    public String execute() {
        return """
                Available commands:
                - go [direction]  → Move to a new location
                - pickUp [item]   → Pick up an item
                - putDown [item]  → Drop an item
                - talk [npc]      → Talk to a character
                - fight [enemy]   → Engage in combat
                - explore         → Look around
                - hint            → Get a hint
                - end             → Quit the game
                """;
    }

    public boolean exit() {
        return false;
    }
}
