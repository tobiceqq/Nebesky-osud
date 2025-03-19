package command;

public class End implements Command {

    public static boolean exit;

    @Override
    public String execute() {
        return "The game is over!";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
