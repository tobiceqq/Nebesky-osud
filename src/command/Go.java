package command;

import world.WorldMap;

public class Go implements Command {

        private WorldMap worldMap;
        private String direction;

    public Go(WorldMap worldMap, String direction) {
        this.worldMap = worldMap;
        this.direction = direction;
    }

    public String execute() {
        int parsedDirection = Integer.parseInt(direction);

        if (parsedDirection == -1) {
            return "Invalid direction! Use: north, south, east, or west.";
        }

            boolean moved = worldMap.move(parseDirection(direction));
            return moved ? "You have moved to: " + worldMap.getCurrentLocation().getName() : "You can't go there.";
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

