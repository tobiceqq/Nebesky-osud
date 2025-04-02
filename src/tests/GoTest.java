package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import world.Location;
import world.WorldMap;

import java.util.HashMap;

public class GoTest {

    @Test

    void testMoveEastFromWindGate() {

        HashMap<Integer, Location> testWorld = new HashMap<>();
        testWorld.put(0, new Location("Wind Gate", 0, new int[]{-1, -1, 1, -1,}));
        testWorld.put(1, new Location("Island of White Shadows", 1, new int[]{-1, -1, 2, 0}));

        WorldMap worldMap = new WorldMap();
        worldMap.setWorld(testWorld);

        String result = worldMap.move("east");

        assertEquals("❌ The wind blocks your way. Use the Wind Scroll first.", result);
        assertEquals(0, WorldMap.getCurrentPosition());

    }

    @Test

    void testMoveBlockedDirection() {
        HashMap<Integer, Location> testWorld = new HashMap<>();
        testWorld.put(0, new Location("Wind Gate", 0, new int[]{-1, -1, -1, -1,}));

        WorldMap worldMap = new WorldMap();
        worldMap.setWorld(testWorld);

        String result = worldMap.move("west");

        assertEquals("❌ You can't move in this direction.", result);
        assertEquals(0, WorldMap.getCurrentPosition());
    }

    @Test

    void testInvalidDirectionInput() {
        WorldMap worldMap = new WorldMap();
        String result = worldMap.move("up");

        assertEquals("❌ Invalid direction. Type only these directions: north (n), south (s), east (e), west (w)" , result);
    }
}
