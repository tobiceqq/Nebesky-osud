package characters;

public class Boss extends Enemy{

    private String specialAttack;

    public Boss(int health, int attackPower, String specialAttack) {
        super(health, attackPower);
        this.specialAttack = specialAttack;
    }


    public void useSpecialAttack(Player player) {
        System.out.println("Boss uses " + specialAttack + "!");
        player.takeDamage(getAttackPower() * 2);
    }

    public String getSpecialAttack() {
        return specialAttack;
    }
}
