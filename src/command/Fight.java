package command;

import characters.Enemy;
import characters.Player;
import world.WorldMap;

import java.util.Scanner;

public class Fight implements Command {

    private WorldMap worldMap = new WorldMap();
    Scanner scanner = new Scanner(System.in);

    @Override
    public String execute() {
        System.out.println("Where do you want to go?");

        String direction = scanner.next();
        direction = direction.toLowerCase();

       // System.out.println(worldMap.move);
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }


}
