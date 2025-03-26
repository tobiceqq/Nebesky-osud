
import world.Console;
import world.WorldMap;

public class  Main {
    public static void main(String[] args) {
        WorldMap worldMap = new WorldMap();
        worldMap.loadMap();
        System.out.println(worldMap.getWorld());
        Console console = new Console();
        console.start();


    }
}
