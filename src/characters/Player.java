package characters;

import command.Backpack;

public class Player {

    private String name = "Haruto";
    private int damage = 20;
    private int hp = 100;
    private static Player instance = new Player();

    public Player() {
    }

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
// mozna potreba upravit
    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "Player → " + "name: " + name + ", damage: " + damage + ", hp: " + hp;
    }
}
