package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import world.Location;
import world.WorldMap;

import java.util.HashMap;

public class GoTest {

    @Test

    void testMoveEastFromWindGate() {

        HashMap<Integer, Location> world = new HashMap<>();
        world.put(0, new Location("Wind Gate", 0, new int[]{-1, -1, 1, -1,}));
        world.put(1, new Location("Island of White Shadows", 1, new int[]{-1, -1, 2, 0}));

        WorldMap worldMap = new WorldMap();

        String result = worldMap.move("east");

        assertEquals("✅ You moved to Island of White Shadows!", result);
        assertEquals(1, WorldMap.getCurrentPosition());

    }
}
