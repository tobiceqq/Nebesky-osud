package command;

import characters.Player;
import world.Location;
import world.WorldMap;

import java.util.ArrayList;

public class Description implements Command {


    private Location location = new Location();
    private WorldMap worldMap = new WorldMap();
    private ArrayList<Location> world = new ArrayList<>();


    @Override
    public String execute() {
        int position = WorldMap.getCurrentPosition();
        Location location1 = world.get(position);

        switch (position) {
            case 0:
                return "\uD83C\uDF2C\uFE0F Wind Gate\\nYou awaken in a quiet stone circle where the wind howls endlessly.\\nThere’s an ancient scroll on the ground.\\nThe path south leads to a mysterious island.";

            case 1:
                return "\uD83D\uDC7B Island of White Shadows\\nShadows dance silently around broken shrines.\\nYou sense a bell might calm them.\\nPaths: south to forest.";

            case 2:
                return "\uD83C\uDF32 Heavenly Forest\\nA peaceful place bathed in golden light. You meet a monk named Hikari.\\nShe may help you.\\nPaths: east to a raging storm.";

            case 3:
                return "⛈\uFE0F Island of Storms\\nA violent storm rages here. Without protection, you cannot proceed.\\nPaths: east to a castle.";

            case 4:
                return "\uD83C\uDFF0 Sky Castle\\nDark towers loom ahead. A powerful enemy awaits.\\nYour brother is here, imprisoned.\\nPaths: south to a sacred shrine.";

            case 5:
                return "\uD83D\uDC09 Shrine of the Mist Dragon\\nAncient carvings glow faintly. Something important lies hidden.\\nPaths: east to a broken bridge.";

            case 6:
                return "\uD83C\uDF09 Collapsed Bridge\\nA chasm blocks your way. A magical key might restore the path.\\nPaths: east to the final shrine.";

            case 7:
                return "✨ Sacred Shrine\\nYou stand before destiny. The final battle awaits.\\nPlace the Celestial Seal to face Raijinmaru.";

            default:
                return "❌ Unknown location.";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
