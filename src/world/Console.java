package world;

import command.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private boolean exit = false;
    private HashMap<String, Command> map = new HashMap<>();
    private WorldMap worldMap = new WorldMap();
    public static String commandFile = "command_file.txt";


    public void initialize() {
        map.put("go",new Go(worldMap));
        map.put("1", new Go(worldMap));

        map.put("commands", new Help());
        map.put("c", new Help());


        map.put("end", new End());
        map.put("2", new End());

        map.put("talk", new Talk());
        map.put("3", new Talk());

        map.put("explore", new Explore(worldMap.getCurrentPosition1()));
        map.put("4", new Explore(worldMap.getCurrentPosition1()));

        map.put("backpack", new Backpack());
        map.put("5", new Backpack());

        map.put("fight", new Fight());
        map.put("6", new Fight());


    }

    private Scanner scanner = new Scanner(System.in);
    private void proved(){
        System.out.println("➜ What you want to do?");
        String command = scanner.nextLine();
        command = command.trim();
        command = command.toLowerCase();
        saveCommand(command);
        if(map.containsKey(command)){
            System.out.println("● "+map.get(command).execute());
            exit = map.get(command).exit();
        }else{
            System.out.println("\uD83D\uDEAB Undefined command");
        }
    }

    public void start(){
        initialize();
        System.out.println();
        System.out.println("WELCOME TO DESTINY OF THE SKY!");
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

    private void saveCommand(String prikaz){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(commandFile,true))){
            bw.write(prikaz);
            bw.newLine();
        }catch(Exception e){

        }
    }

    private void fileReset(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(commandFile,false))){
        }catch(Exception e){
        }
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }
}