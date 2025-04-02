package command;

import characters.Player;
import world.Item;
import world.ItemCategory;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents the player's backpack (inventory).
 * Allows viewing, managing, and activating collected items.
 * Implements the Command interface.
 */
public class Backpack implements Command {

    private static final ArrayList<Item> backpack = new ArrayList<>();

    public static ArrayList<Item> getBackpack() {
        return backpack;
    }

    /**
     * Adds an item to the backpack and prints a confirmation message.
     *
     * @param item the item to be added
     */
    public static void addItem(Item item) {
        backpack.add(item);
        System.out.println("\uD83D\uDCE6 Collected: " + item.getName());
    }

    /**
     * Executes the backpack command, allowing the player to view or activate items via console interaction.
     *
     * @return an empty string (no further message)
     */
    @Override
    public String execute() {
        Scanner input = new Scanner(System.in);

        if (backpack.isEmpty()) {
            System.out.println("\uD83D\uDEAB Your backpack is empty.");
            return "";
        }

        System.out.println("1\uFE0F⃣ View inventory");
        System.out.println("2\uFE0F⃣ Activate item");
        System.out.println("Choose: ");

        String selection = input.nextLine().trim();

        switch (selection) {
            case "1" -> printInventory();
            case "2" -> activateItem(input);
            default -> System.out.println("❌ Unknown command.");
        }
        return "";
    }

    /**
     * Prints all items currently in the backpack with their descriptions.
     */
    private void printInventory() {
        System.out.println("\uD83C\uDF92 Backpack contents: ");
        for (int i = 0; i < backpack.size(); i++) {
            Item item = backpack.get(i);
            System.out.println((i + 1) + ": " + item.getName() + " → " + item.getDescription());
        }
    }

    /**
     * Allow the player to select and activate an item from the backpack.
     * Applies effects depending on the item's category.
     *
     * @param input the Scanner used for reading user input
     */
    private void activateItem(Scanner input) {
        printInventory();
        System.out.println("Select item to use (number): ");

        if (!input.hasNextInt()) {
            System.out.println("❌ That is not a number.");
            input.nextLine();
            return;
        }

        int choice = input.nextInt() - 1;
        input.nextLine();

        if (choice < 0 || choice >= backpack.size()) {
            System.out.println("⚠\uFE0F Invalid item index.");
            return;
        }

        Item chosen = backpack.get(choice);
        Player player = Player.getInstance();

        switch (chosen.getCategory()) {
            case HEAL -> {
                int healed = chosen.getHpBoost();
                player.setHp(player.getHp() + healed);
                backpack.remove(choice);
                System.out.println("❤\uFE0F Healed by " + healed + " hp. Current hp: " + player.getHp());
            }

            case POWER -> {
                int boost = chosen.getDamageBoost();
                player.setDamage(player.getDamage() + boost);
                backpack.remove(choice);
                System.out.println("\uD83D\uDDE1\uFE0F Damage increased by " + boost + ". Current damage: " + player.getDamage());
            }

            case ACCESS -> System.out.println("\uD83D\uDCDC" + chosen.getName() + " has been activated.");

            default -> System.out.println("❓ No effect found.");
        }
    }

    /**
     * Indicates whether this command should cause the game to exit.
     * @return
     */
    @Override
    public boolean exit() {
        return false;
    }
}
