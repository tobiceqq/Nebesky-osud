package command;

import org.junit.jupiter.api.Test;
import world.Item;
import world.ItemCategory;

import static org.junit.jupiter.api.Assertions.*;

class BackpackTest {

    @Test
    void getBackpack() {
        Backpack backpack = new Backpack();
        backpack.getBackpack().add(new Item("Wind Scroll", "needed to get to next location", ItemCategory.SCROLL));
        backpack.getBackpack().add(new Item("x", "x", ItemCategory.WEAPON));
        assertEquals("Wind Scroll", backpack.getBackpack().get(0).getName());
        assertEquals("x", backpack.getBackpack().get(0).getName());
    }

}