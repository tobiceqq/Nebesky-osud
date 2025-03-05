package command;

public class End implements Command {

    public String execute() {
        return "The game is over!";
    }

    public boolean exit() {
        return true;
    }
}
