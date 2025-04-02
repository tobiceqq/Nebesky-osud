package command;

import world.WorldMap;

import java.util.Scanner;

/**
 * Command that handles player movement between locations.
 * Prompts the player for a direction and attempts to move in that direction.
 *
 * @author ChatGPT
 */
public class Go implements Command {

        private WorldMap worldMap;
        private Scanner scanner = new Scanner(System.in);

    public Go(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    /**
     * Executes the movement command.
     * Asks the user for a direction and updates the location accordingly.
     *
     * @return an empty string (movement output is printed to console)
     */
    public String execute() {
        System.out.println("✅ You are in: " + worldMap.getCurrentPosition1().getName());
        System.out.println("Which way you want to go?");

        String direction = scanner.next();
        direction = direction.toLowerCase();

        System.out.println(worldMap.move(direction));
        return "";
        }

    /**
     * This command does not cause the game to exit.
     *
     * @return false
     */
    @Override
    public boolean exit() {
        return false;
    }
}






