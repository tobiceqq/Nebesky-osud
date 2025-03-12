package characters;

public class Enemy extends Player {

    private static Enemy instance;
    private int health;
    private int attackPower;

    public Enemy() {
    }

    public Enemy(int health, int attackPower) {
        super(health);
        this.attackPower = attackPower;
    }

    public static Enemy getInstance() {
        if (instance == null) {
            instance = new Enemy();
        }
        return instance;
    }


    public int getHealth() {

        return health;
    }


    public int getAttackPower() {

        return attackPower;
    }


    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
        System.out.println("You took damage! Health lefta: " + health);
    }


    public boolean isDefeated() {

        return health <= 0;
    }


    public void attack(Player player) {
        if (isDefeated()) {
            System.out.println(getName() + " is already defeated!");
            return;
        }

        System.out.println(getName() + " attacks " + player.getName() + " for " + attackPower + " damage!");
        player.takeDamage(attackPower);

    }
}
