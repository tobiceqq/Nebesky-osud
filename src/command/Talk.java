package command;

public class Talk implements Command {

    private Character character;


    public String execute() {
        return character.getDialogue();
    }

    public boolean exit() {
        return false;
    }
}
