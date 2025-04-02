package characters;

import command.Backpack;

/**
 * Represents the player character in the game.
 * Implements a singleton pattern to ensure a single instance of the player exists.
 */
public class Player {

    private String name = "Haruto";
    private int damage = 20;
    private int hp = 100;
    private static Player instance = new Player();
    private boolean brotherAvailable = false;

    public Player() {
    }

    /**
     * Returns the single instance of the player.
     * Creates new instance if none exists.
     *
     * @return the singleton Player instance
     */
    public static Player getInstance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isBrotherAvailable() {
        return brotherAvailable;
    }

    public void setBrotherAvailable(boolean available) {
        this.brotherAvailable = available;
    }

    @Override
    public String toString() {
        return "Player → " + "name: " + name + " | damage: " + damage + " | hp: " + hp;
    }
}
