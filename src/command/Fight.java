package command;

import characters.Enemy;
import characters.Player;

public class Fight implements Command {

    private Player player;
    private Enemy enemy;

    public Fight(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public String execute() {
        if (enemy == null) return "No enemy here to fight.";

        while (!enemy.isDefeated() && player.isAlive()) {
            player.attack(enemy);
            if (enemy.isDefeated()) return "You defeated " + enemy.getName() + "!";

            enemy.attack(player);
        }

        return player.isAlive() ? "You won the fight!" : "You were defeated!...";
    }

    public boolean exit() {
        return enemy.isDefeated();
    }
}
