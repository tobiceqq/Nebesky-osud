package command;

import world.WorldMap;

import java.util.Scanner;

public class Go implements Command {

        private WorldMap worldMap;
        private Scanner scanner = new Scanner(System.in);

    public Go(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    public String execute() {
        System.out.println("✅ You are in: " + worldMap.getCurrentPosition1().getName());
        System.out.println("Which way you want to go?");

        String direction = scanner.next();
        direction = direction.toLowerCase();

        System.out.println(worldMap.move(direction));
        return "";
        }

    @Override
    public boolean exit() {
        return false;
    }
}






