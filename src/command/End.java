package command;

public class End implements Command {

    public static boolean exit;

    @Override
    public String execute() {
        return "\uD83C\uDFAE The game is over!";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
