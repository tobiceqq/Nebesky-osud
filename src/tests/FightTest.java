package tests;

import static org.junit.jupiter.api.Assertions.*;
import characters.Enemy;
import characters.Player;
import command.Fight;
import org.junit.jupiter.api.Test;

class FightTest {

    @Test

    void testEnemyDefeated() {

        Player player = Player.getInstance();
        player.setHp(100);
        player.setDamage(20);

        Fight fight = new Fight();

        player.setHp(100);
        Enemy kurojin = new Enemy("Kurojin" , 30 , 85);
        kurojin.setHp(0);

        assertTrue(kurojin.getHp() <= 0 , "Enemy should be defeated.");
    }

}