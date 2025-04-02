package tests;

import static org.junit.jupiter.api.Assertions.*;
import command.Description;
import org.junit.jupiter.api.Test;
import world.WorldMap;

public class DescriptionTest {

    @Test

    void execute() {

        WorldMap worldMap = new WorldMap();
        worldMap.loadMap();
        Description description = new Description();

        String expected = description.execute();

        assertTrue(expected.contains("Wind Gate") || expected.isEmpty());
    }
}
