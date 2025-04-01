package tests;

import static org.junit.jupiter.api.Assertions.*;
import command.Description;
import org.junit.jupiter.api.Test;
import world.WorldMap;

public class DescriptionTest {

    @Test

    void execute() {

        WorldMap worldMap = new WorldMap();
        Description description = new Description();

        String expected = "\uD83C\uDF2C\uFE0F Wind Gate ➡\uFE0F You awaken in a quiet stone circle where the wind howls endlessly. There’s an ancient scroll on the ground. The path east leads to a mysterious island.";
        assertEquals(expected , description.execute());
    }
}
