package world;

import command.*;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

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