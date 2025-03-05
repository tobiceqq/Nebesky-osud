package command;

public class Help implements Command {


    public String execute() {
        return "Available commands: go, pickUp, putDown, talk, fight, explore, hint";
    }

    public boolean exit() {
        return false;
    }
}
