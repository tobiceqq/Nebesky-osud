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
        map.put("commands", new Help());
        map.put("end", new End());

    }

    private Scanner scanner = new Scanner(System.in);
    private void proved(){
        System.out.println("➜ What you want to do?");
        String prikaz = scanner.nextLine();
        prikaz = prikaz.trim();
        prikaz = prikaz.toLowerCase();
        saveCommand(prikaz);
        if(map.containsKey(prikaz)){
            System.out.println(">> "+map.get(prikaz).execute());
            exit = map.get(prikaz).exit();
        }else{
            System.out.println(">> Undefined command");
        }
    }

    public void start(){
        initialize();
        System.out.println();
        System.out.println("WELCOME TO THE DESTINY OF THE SKY!");
        System.out.println("\uD83D\uDD0D For available commands type 'commands'");
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