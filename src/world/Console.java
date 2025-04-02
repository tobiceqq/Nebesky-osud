package world;

import command.*;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Represents the main console interface for the game.
 * Handles user input, command execution, command initialization and logging of all entered commands.
 */
public class Console {
    private boolean exit = false;
    private HashMap<String, Command> map = new HashMap<>();
    private WorldMap worldMap = new WorldMap();
    public static String commandFile = "textFiles/command_file.txt";

    public Console() {

        Text intro = new Text("src/textFiles/introduction.txt");
        System.out.println("☁\uFE0F WELCOME TO DESTINY OF THE SKY! ☁\uFE0F");
        System.out.println();
        System.out.println(intro.startText());
    }



    /**
     * Initializes the command map by associating string inputs with Command instances.
     * Supports both full command words and numeric shortcuts (1-7).
     */
    public void initialize() {
        map.put("go",new Go(worldMap));
        map.put("1", new Go(worldMap));

        map.put("commands", new Help());
        map.put("c", new Help());


        map.put("fight", new Fight());
        map.put("2", new Fight());

        map.put("talk", new Talk());
        map.put("3", new Talk());

        map.put("description", new Description());
        map.put("4", new Description());

        map.put("explore", new Explore(worldMap.getCurrentPosition1()));
        map.put("5", new Explore(worldMap.getCurrentPosition1()));

        map.put("backpack", new Backpack());
        map.put("6", new Backpack());

        map.put("end", new End());
        map.put("7", new End());


    }

    /**
     * Asks the player what they want to do, read their input, logs it and executes the appropriate command.
     */
    private Scanner scanner = new Scanner(System.in);
    private void proved(){
        System.out.println("➜ What you want to do?");
        String command = scanner.nextLine();
        command = command.trim();
        command = command.toLowerCase();
        saveCommand(command);
        if(map.containsKey(command)){
            System.out.println(map.get(command).execute());
            exit = map.get(command).exit();
        }else{
            System.out.println("❌ Undefined command");
        }
    }

    /**
     * Starts the game loop. Loads the world map and shows help and repeatedly prompts for commands till the game ends.
     */
    public void start(){
        worldMap.loadMap();
        initialize();
        System.out.println("\uD83D\uDD0D For available commands type 'commands' or 'c'");
        try{
            fileReset();
            do{
                proved();
            }while(!exit);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Saves a command to the command log file.
     * @param command the command string entered by the player
     */
    private void saveCommand(String command){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(commandFile,true))){
            bw.write(command);
            bw.newLine();
        }catch(Exception e){

        }
    }

    /**
     * Clears the command log file before starting a new session.
     */
    private void fileReset(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(commandFile,false))){
        }catch(Exception e){
        }
    }

    /**
     * Gets the exit flag.
     *
     * @return true if the game should exit, false otherwise
     */
    public boolean isExit() {
        return exit;
    }

    /**
     * Sets the exit flag.
     *
     * @param exit true to end, false to continue
     */
    public void setExit(boolean exit) {
        this.exit = exit;
    }
}