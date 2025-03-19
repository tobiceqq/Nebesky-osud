package command;

public class Help implements Command {


    public String execute() {
        return """
                Available commands:
                - go              → Move to a new location
                - talk            → Talk to a character
                - fight           → Engage in combat
                - explore         → Look around
                - end             → Quit the game
                """;
    }

    public boolean exit() {
        return false;
    }
}
