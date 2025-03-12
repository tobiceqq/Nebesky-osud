package characters;

import command.Backpack;

public class Player {

    private static Player instance;
    private String name;
    private String description;
    private int health;
    private int maxHealth;
    private int attack;
    private Backpack backpack;

    public Player(int health) {
        this.health = health;
    }

    public Player() {
    }

    public Player(String name, String description, int health, int maxHealth, int attack) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.maxHealth = health;
        this.attack = attack;
    }

    public static Player getInstance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) health = 0;
        System.out.println("You took " + damage + " damage! Health left: " + health);
    }

    public String getName() {

        return name;
    }

    public String getDescription() {

        return description;
    }

    public void interact() {

    }

    public boolean isAlive() {

        return health > 0;
    }

    public int getHealth() {

        return health;
    }

    public void heal(int amount) {
        health += amount;
        if (health > maxHealth) health = maxHealth;
        System.out.println("You healed for " + amount + " HP! Current health: " + health);
    }

    public void attack(Enemy enemy) {
        enemy.takeDamage(10);
        System.out.println("You attacked " + enemy.getName() + " for 10 damage!");
    }

    public void setMaxHealth(int newMaxHealth) {
        this.maxHealth = newMaxHealth;
        if (health > maxHealth) health = maxHealth;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
