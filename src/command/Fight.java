package command;

import characters.Enemy;
import characters.Player;
import world.WorldMap;

import java.util.Random;
import java.util.Scanner;

/**
 * Command that initiates and handles a turn-based fight between the player and an enemy.
 * The enemy depends on the player's current location.
 */
public class Fight implements Command {

    private Enemy enemy;
    private boolean isDefeated = false;
    Random random = new Random();

    /**
     * Executes the fight command.
     * Depending on the current position, an enemy may appear and a fight may begin.
     *
     * @return a message about the result of the fight or absence of enemies
     */
    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        int currentPosition = WorldMap.getCurrentPosition();
        Enemy enemy = Enemy.getEnemyIn(currentPosition);
        Player player = Player.getInstance();


        switch (currentPosition) {

            case 0 -> {
                return "\uD83D\uDEAB No enemies in sight.";
            }
            case 1 -> enemy = new Enemy("Heavenly guardian (weak)", 10, 70 );
            case 2 -> {
                return "\uD83D\uDEAB No enemies in sight.";
            }
            case 3 -> enemy = new Enemy("Heavenly guardian (strong)", 20, 80 );
            case 4 -> enemy = new Enemy("Kurojin", 30, 85 );
            case 5 -> {
                return "\uD83D\uDEAB No enemies in sight.";
            }
            case 6 -> {
                return "\uD83D\uDEAB No enemies in sight.";
            }
            case 7 -> enemy = new Enemy("Raijinmaru", 25, 100 );
            default -> {
                return "\uD83D\uDEAB No enemy in sight.";
            }
        }

        // Display stats
        System.out.println("⚔\uFE0F This is " + enemy.getName() + "!");
        System.out.println("\uD83E\uDDDF Enemy stats →   ❤\uFE0F hp: " + enemy.getHp() + " | \uD83D\uDDE1\uFE0F damage: " + enemy.getDamage());
        System.out.println("--");
        System.out.println("\uD83E\uDDCD Your stats →   ❤\uFE0F hp: " + player.getHp() + " | \uD83D\uDDE1\uFE0F damage: " + player.getDamage());
        System.out.println("\uD83D\uDCDD To begin the fight you must type 'f' ");
        String input = sc.nextLine().toLowerCase();

        if (input.equals("f")) {
            System.out.println("⚔\uFE0F The fight between you and " + enemy.getName() + " starts! ⚔\uFE0F");

            while (player.getHp() > 0 && enemy.getHp() > 0) {
                // Print round status
                System.out.println("\uD83C\uDFAF " + enemy.getName() + "→   ❤\uFE0F hp: " + enemy.getHp() + "    |    \uD83D\uDDE1\uFE0F damage: " + enemy.getDamage());
                System.out.println("\uD83E\uDDCD " + player.getName() + "→   ❤\uFE0F hp: " + player.getHp() + "    |  \uD83D\uDDE1\uFE0F damage: " + player.getDamage());

                // Player attacks
                enemy.setHp(enemy.getHp() - player.getDamage());
                if (enemy.getHp() <= 0) {
                    int damageBonus = random.nextInt(10, 15);
                    int hpBonus = random.nextInt(15, 25);

                    System.out.println("✅ You defeated the enemy!");
                    player.setDamage(player.getDamage() + damageBonus);
                    player.setHp(player.getHp() + hpBonus);
                    return "\uD83C\uDF81 You earned ❤\uFE0F hp: " + hpBonus + "    |    \uD83D\uDDE1\uFE0F damage: " + damageBonus;
                }


                // Enemy attacks
                player.setHp(player.getHp() - enemy.getDamage());
                if (player.getHp() <= 0) {
                    System.out.println("❌ You were defeated!");
                    End.exit = true;
                    isDefeated = true;
                }
            }
        }
        return "";
    }

    /**
     * Indicates if the player was defeated, which should cause the game to end.
     *
     * @return true if player lost the fight, false otherwise
     */
    @Override
    public boolean exit() {
        return isDefeated;
    }
}