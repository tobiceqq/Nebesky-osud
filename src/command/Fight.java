package command;

import characters.Enemy;

public class Fight implements Command {

    private Enemy enemy;


    public String execute() {
        return "The fight is in progress";
    }


    public boolean exit() {
        return enemy.isDefeated();
    }
}
