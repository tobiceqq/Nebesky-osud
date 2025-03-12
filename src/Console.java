import characters.Enemy;
import characters.NPC;
import characters.Player;
import command.*;
import world.Item;
import world.WorldMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Console {

    private Scanner scanner;
    private Map<String, Command> commands;

    public Console(Scanner scanner, Map<String, Command> commands) {
        this.scanner = new Scanner(System.in);
        this.commands = new HashMap<>();

        commands.put("explore", new Explore(WorldMap.getInstance().getCurrentLocation()));
        commands.put("fight", new Fight(Player.getInstance(), Enemy.getInstance()));
        commands.put("pick up", new PickUp(new Item("", "", true), Player.getInstance().getBackpack()));
        commands.put("put down", new PutDown(new Item("", "", true), Player.getInstance().getBackpack()));
        commands.put("talk", new Talk(NPC.getInstance()));
        commands.put("hint", new Hint(WorldMap.getInstance().getCurrentLocation()));
        commands.put("help", new Help());
        commands.put("use", new Use(new Item("", "", true)));
    }

    public void startGame() {
        System.out.println("Welcome to The Destiny of the Sky!");
        System.out.println("Type 'help' to see available commands.");

        boolean running = true;
        while (running) {
            String command = readCommand();
            running = processCommand(command);
        }
        System.out.println("Game Over.");
    }

    private String readCommand() {
        System.out.print("> ");
        return scanner.nextLine().trim().toLowerCase();
    }

    private boolean processCommand(String command) {
        if (command.equals("go")) {
            printMessage("Enter direction (north, south, east, west): ");
            String direction = readCommand();
            printMessage(new Movement(WorldMap.getInstance(), direction).execute());
        } else if (commands.containsKey(command)) {
            printMessage(commands.get(command).execute());
        } else if (command.equals("exit")) {
            return false;
        } else {
            printMessage("Unknown command. Type 'help' to see available commands.");
        }
        return true;
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}

