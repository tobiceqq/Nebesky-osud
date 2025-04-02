package command;

/**
 * Command that ends the game.
 * When executed, it signals the game to terminate.
 */
public class End implements Command {

    public static boolean exit;

    /**
     * Executes the command and returns a message indicating the game has ended.
     *
     * @return a message about the game being ended
     */
    @Override
    public String execute() {
        return "\uD83C\uDFAE The game is over!";
    }

    /**
     * Indicates that this command ends the game.
     *
     * @return true (exit the game)
     */
    @Override
    public boolean exit() {
        return true;
    }
}
