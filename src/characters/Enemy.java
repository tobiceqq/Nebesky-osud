package characters;

import java.util.HashMap;
import java.util.Random;

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

    public static void addEnemy(int location, Enemy enemy) {
        enemies.put(location, enemy);
    }

    public static void removeEnemy(int location) {
        enemies.remove(location);
    }

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
        return "Enemy → " + "name: " + name + ", damage: " + damage + ", hp: " + hp;
    }
}
