package characters;

public class Enemy {

    private int health;
    private int attackPower;


    public int getHealth() {
        return health;
    }


    public int getAttackPower() {
        return attackPower;
    }


    public void takeDamage(int damage) {
        health -= damage;
    }


    public boolean isDefeated() {
        return health <= 0;
    }


    public void attack(Player player) {

    }
}
