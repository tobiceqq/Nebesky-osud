package command;

public class Help implements Command {


    public String execute() {
        return """
                Available commands:
                1️⃣ go              → Move to a new location
                2️⃣ end             → Quit the game
                3️⃣ talk            → Talk to a character
                4️⃣ explore         → Look around
                5️⃣ backpack        → Shows your inventory
                6️⃣ fight           → Engage in combat
                """;
    }

    public boolean exit() {
        return false;
    }
}
