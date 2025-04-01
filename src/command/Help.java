package command;

public class Help implements Command {


    public String execute() {
        return """
                Available commands:
                1️⃣ go              → Move to a new location
                2️⃣ fight           → Engage in combat Quit the game
                3️⃣ talk            → Talk to a character
                4️⃣ description     → Get a description of your surroundings
                5️⃣ explore         → Look around
                6️⃣ backpack        → Shows your inventory
                7️⃣ end             → Quit the game
                """;
    }

    public boolean exit() {
        return false;
    }
}
