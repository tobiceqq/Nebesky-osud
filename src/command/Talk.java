package command;

import world.WorldMap;
import characters.NPC;

/**
 * Command that allows the player to talk to an NPC
 * present at their current location.
 */
public class Talk implements Command {

        private NPC character;

        public Talk() {
            this.character = character;
        }

    /**
     * Executes the talk command.
     * If an NPC is present at the current location, returns their dialogue.
     * Otherwise, informs the player that no one is present.
     *
     * @return a dialogue string or a message indicating nobody is there
     */
    public String execute() {
            int currentPosition = WorldMap.getCurrentPosition();
            NPC npc = NPC.getNPCIn(currentPosition);
            if (npc != null) {
                return npc.talk();
            } else {
                return "❌ Silence... There's no one in sight.";
            }
        }

    /**
     * This command does not end the game.
     *
      * @return false
     */
    @Override
    public boolean exit() {
        return false;
    }
}
