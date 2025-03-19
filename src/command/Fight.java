package command;

import characters.Enemy;
import characters.Player;
import world.WorldMap;

import java.util.Random;
import java.util.Scanner;

public class Fight implements Command {

    private Enemy enemy;
    private boolean isDefeated = false;
    Random random = new Random();

    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        int currentPosition = WorldMap.getCurrentPosition();
        Enemy enemy = Enemy.getEnemyIn(currentPosition);
        Player player = Player.getInstance();


        switch (currentPosition) {

            case 0 -> enemy = null;
            case 1 -> enemy = new Enemy("Heavenly guardian (weak)", 15, 70 );
            case 2 -> enemy = null;
            case 3 -> enemy = new Enemy("Heavenly guardian (strong)", 25, 80 );
            case 4 -> enemy = new Enemy("Kurojin", 30, 85 );
            case 5 -> enemy = null;
            case 6 -> enemy = null;
            case 7 -> enemy = new Enemy("Raijinmaru", 35, 100 );
            default -> {
                return "No enemy in sight.";
            }
        }

        System.out.println("This is " + enemy.getName() + "!");
        System.out.println("Enemy stats →   hp: " + enemy.getHp() + "| damage: " + enemy.getDamage());
        System.out.println("--");
        System.out.println("Your stats →   hp: " + player.getHp() + "| damage: " + player.getDamage());
        System.out.println("To begin the fight you must type 'f' ");
        String input = sc.nextLine().toLowerCase();

        if (input.equals("f")) {
            System.out.println("The fight between you and " + enemy.getName() + "starts!");

            while (player.getHp() > 0 && enemy.getHp() > 0) {
                System.out.println(enemy.getName() + "→   hp: " + enemy.getHp() + "| damage: " + enemy.getDamage());
                System.out.println(player.getName() + "→   hp: " + player.getHp() + "| damage: " + player.getDamage());

                enemy.setHp(enemy.getHp() - player.getDamage());
                if (enemy.getHp() <= 0) {
                    int damageBonus = random.nextInt(10, 15);
                    int hpBonus = random.nextInt(15, 25);

                    System.out.println("You defeated the enemy!");
                    player.setDamage(player.getDamage() + damageBonus);
                    player.setHp(player.getHp() + hpBonus);
                    return "You earned hp: " + hpBonus + " and damage: " + damageBonus;
                }

                player.setHp(player.getHp() - enemy.getDamage());
                if (player.getHp() <= 0) {
                    System.out.println("You were defeated!");
                    End.exit = true;
                    isDefeated = true;
                }
            }
        }
        return "";
    }

    @Override
    public boolean exit() {
        return isDefeated;
    }
}