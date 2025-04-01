package tests;

import static org.junit.jupiter.api.Assertions.*;
import command.Backpack;
import org.junit.jupiter.api.Test;
import world.Item;
import world.ItemCategory;

import java.util.List;


class BackpackTest {

    @Test
    void testAddItem() {

        Item item = new Item("Test potion", "Heals 10 HP", ItemCategory.HEAL);

        Backpack.getBackpack().clear();
        Backpack.addItem(item);

        List<Item> backpack = Backpack.getBackpack();

        assertFalse(backpack.isEmpty(), "Backpack should not be empty.");
        assertEquals(1 , backpack.size(), "Backpack should contain one item.");
        assertEquals("Test potion" , backpack.get(0).getName(), "Item name should match.");


    }

}