package command;

public class End implements Command {

    @Override
    public String execute() {
        return "The game is over!";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
