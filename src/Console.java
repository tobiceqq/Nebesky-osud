import java.util.Scanner;

public class Console {

    private Scanner scanner;

    public void startGame() {
        System.out.println("Welcome to The Destiny of the sky!");

    }

    public String readCommand() {
        System.out.print("> ");
        return scanner.nextLine();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
