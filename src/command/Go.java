package command;

import world.WorldMap;

public class Go implements Command {

        private WorldMap worldMap;
        private String direction;


        public String execute() {
            boolean moved = worldMap.move(parseDirection(direction));
            return moved ? "You have moved to another location." : "You cant go there.";
        }

        public boolean exit() {
            return false;
        }

        private int parseDirection(String direction) {
            switch (direction.toLowerCase()) {
                case "north": return 0;
                case "south": return 1;
                case "east": return 2;
                case "west": return 3;
                default: return -1;
            }
        }
    }

