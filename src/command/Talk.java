package command;

import world.WorldMap;
import characters.NPC;

public class Talk implements Command {

        private NPC character;

        public Talk() {
            this.character = character;
        }

        public String execute() {
            int currentPosition = WorldMap.getCurrentPosition();
            NPC npc = NPC.getNPCIn(currentPosition);
            if (npc != null) {
                return npc.talk();
            } else {
                return "Silence... There's no one in sight.";
            }
        }

    @Override
    public boolean exit() {
        return false;
    }
}
