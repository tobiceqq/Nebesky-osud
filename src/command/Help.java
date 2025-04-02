package command;

/**
 * Command that displays a list of available commands the player can use.
 * Useful for reminding the player of the possible actions in the game.
 */
public class Help implements Command {


    /**
     * Executes the help command by returning a formatted list of instructions.
     *
     * @return a multi-line string containing all available game commands
     */
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

    /**
     * Indicates whether this command should end the game.
     * This command does not end the game.
     *
     * @return false
     */
    public boolean exit() {
        return false;
    }
}
