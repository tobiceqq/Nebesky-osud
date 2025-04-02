package characters;

import java.util.HashMap;
import java.util.Random;

/**
 * Represents an enemy character in the game.
 * Stores it's name, damage, health and location assignment.
 */
public class Enemy {

    private String name;
    private int damage;
    private int hp;
    Random random = new Random();
    private static HashMap<Integer, Enemy> enemies = new HashMap<>();

    public Enemy(String name, int damage, int hp) {
        this.name = name;
        this.damage = damage;
        this.hp = hp;
    }

    /**
     * Registers the enemy at a specific location.
     *
     * @param location the location ID
     * @param enemy the enemy instance
     */
    public static void addEnemy(int location, Enemy enemy) {
        enemies.put(location, enemy);
    }

    /**
     * Removes the enemy from the specified location.
     *
     * @param location the ID of the location to remove the enemy
     */
    public static void removeEnemy(int location) {
        enemies.remove(location);
    }

    /**
     * Retrieves the enemy located at the given location.
     *
     * @param location the location ID
     * @return the enemy instance at the given location, or null if none exists
     */
    public static Enemy getEnemyIn(int location) {
        return enemies.get(location);
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

    @Override
    public String toString() {
        return "Enemy → " + "name: " + name + "| damage: " + damage + "| hp: " + hp;
    }
}
