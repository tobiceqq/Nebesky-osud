package command;

import characters.Player;
import world.Location;
import world.WorldMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Description implements Command {

    WorldMap worldMap = new WorldMap();

    public String execute() {
        int currentPosition = worldMap.getCurrentPosition();

        switch (currentPosition) {
            case 0:
                text0();
                break;
            case 1:
                text1();
                break;
            case 2:
                text2();
                break;
            case 3:
                text3();
                break;
            case 4:
                text4();
                break;
            case 5:
                text5();
                break;
            case 6:
                text6();
                break;
            case 7:
                text7();
                break;
            default:
                return "❌ Error while loading ";
        }
        return "";
    }

    public void text0() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/textFiles/wind_gate.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void text1() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/textFiles/island_of_white_shadows.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void text2() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/textFiles/heavenly_forest.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void text3() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/textFiles/island_of_storms.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void text4() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/textFiles/sky_castle.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void text5() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/textFiles/shrine_of_the_mist_dragon.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void text6() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/textFiles/collapsed_bridge.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void text7() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/textFiles/sacred_shine.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }





















  /*  private WorldMap worldMap;

    public Description(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    @Override
    public String execute() {

        List<Location> location = new ArrayList<>(worldMap.getWorld().values());
        int position = WorldMap.getCurrentPosition();


        if (location == null) {
            return "❌ Location not found.";
        }

        switch (position) {
            case 0:
                return "\uD83C\uDF2C\uFE0F Wind Gate ➡\uFE0F You awaken in a quiet stone circle where the wind howls endlessly. There’s an ancient scroll on the ground. The path east leads to a mysterious island.";

            case 1:
                return "\uD83D\uDC7B Island of White Shadows ➡\uFE0F Shadows dance silently around broken shrines. You sense a bell might calm them. Paths: east to forest.";

            case 2:
                return "\uD83C\uDF32 Heavenly Forest ➡\uFE0F A peaceful place bathed in golden light. You meet a monk named Hikari. She may help you. Paths: east to a raging storm.";

            case 3:
                return "⛈\uFE0F Island of Storms ➡\uFE0F A violent storm rages here. Without protection, you cannot proceed. Paths: east to a castle.";

            case 4:
                return "\uD83C\uDFF0 Sky Castle ➡\uFE0F Dark towers loom ahead. A powerful enemy awaits. Your brother is here, imprisoned. Paths: south to a sacred shrine.";

            case 5:
                return "\uD83D\uDC09 Shrine of the Mist Dragon ➡\uFE0F Ancient carvings glow faintly. Something important lies hidden. Paths: east to a broken bridge.";

            case 6:
                return "\uD83C\uDF09 Collapsed Bridge ➡\uFE0F A chasm blocks your way. A magical key might restore the path. Paths: east to the final shrine.";

            case 7:
                return "✨ Sacred Shrine ➡\uFE0F You stand before destiny. The final battle awaits. Place the Celestial Seal to face Raijinmaru.";

            default:
                return "❌ Unknown place.";
        }
    }
*/
    @Override
    public boolean exit() {
        return false;
    }
}
