package command;

/**
 * Represents a command that can be executed by the player.
 * Each command must define its action logic and indicate whether it ends the game.
 */
public interface Command {

    /**
     * Executes the command's main logic.
     * @return optional string output (messages to the console)
     */
    String execute();

    /**
     * Determines whether the command causes the game to exit.
     * @return true if the command ends the game, false otherwise
     */
    boolean exit();
}
