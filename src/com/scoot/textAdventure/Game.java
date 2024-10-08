package com.scoot.textAdventure;

import java.util.Scanner;

import com.scoot.textAdventure.interactions.Interaction;

import com.scoot.textAdventure.locations.*;

/**
 * This class should handle the game actually being played-the only others files that should get modified are in the locations package
 */
public class Game {
    private static Map m_map;
    private static Player m_player;

    // put code here to bulid map
    // THIS IS THE ONLY PLACE YOU SHOULD MODIFY m_map
    private static void loadMap() {
        Location[][] mapArray = new Location[1][1];
        /// create location classes to define each location if you want it to be more encapsulated
        mapArray[0][0] = new ExampleLocation(m_player);
        // create map object once all the Locations are defined
        m_map = new Map(mapArray, new CoordinatePair(0, 0), "MAP CREATED");
        System.out.println(m_map.getBootMessage());
        // create our player object
        CoordinatePair mapDefaultCoordinates = m_map.getDefaultLocationCoordinates();
        m_player = new Player(mapDefaultCoordinates);
        // move them to the start location properly!
        movePlayer(m_player, mapDefaultCoordinates, true);
    }

    /**
     * Tries to have the player enter the relevant location, returns whether it succeeds based on running the relevant entry method
     * @param player
     * @param destination
     * @param teleport Determines whether the code should check if the player is adjacent before allowing the move
     */
    public static boolean movePlayer(Player player, CoordinatePair destination, boolean teleport) {
        // null values are valid as Locations you can't access!
        // but also account for the fact that the way it is someone might accidentally try and move off the map
        try {
            if (m_map.getLocation(destination) == null) {
                System.out.println("You find yourself unable to move in that direction");
                return false;
            }
        } catch (Exception e) {
            System.out.println("You find yourself unable to move in that direction");
            return false;
        }
        // checks whether you can actually move somewhere (special moves can use the teleport flag)
        if (!teleport && !player.isAdjacent(destination)) {
            return false;
        }
        if (player.move(m_map.getLocation(destination))) {
            player.setCoordinates(destination);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input;

        loadMap();
        System.out.println("Enter COMMANDS to see what you can do.");

        while (m_player.isAlive()) {
            while (true) {
                System.out.print("> ");
                input = kb.nextLine();
                if (input.isEmpty()) {
                    continue;
                }

                switch (input) {
                    case "COMMANDS":
                        System.out.println("Type MOVE [CARDINAL DIRECTION] to move between locations");
                        System.out.println("Type SEE INTERACTIONS to see what interactions are available");
                        break;
                    case "MOVE NORTH":
                        movePlayer(m_player, new CoordinatePair(m_player.getCoordinates().getXCoordinate(), m_player.getCoordinates().getYCoordinate() - 1), false);
                        break;
                    case "MOVE SOUTH":
                        movePlayer(m_player, new CoordinatePair(m_player.getCoordinates().getXCoordinate(), m_player.getCoordinates().getYCoordinate() + 1), false);
                        break;
                    case "MOVE EAST":
                        movePlayer(m_player, new CoordinatePair(m_player.getCoordinates().getXCoordinate() + 1, m_player.getCoordinates().getYCoordinate()), false);
                        break;
                    case "MOVE WEST":
                        movePlayer(m_player, new CoordinatePair(m_player.getCoordinates().getXCoordinate() - 1, m_player.getCoordinates().getYCoordinate()), false);
                        break;
                    case "SEE INTERACTIONS":
                        String toPrint = "";
                        for (Interaction interaction : m_map.getLocation(m_player.getCoordinates()).getInteractions()) {
                            toPrint += interaction.getCommand() + ", ";
                        }
                        toPrint = toPrint.substring(0, toPrint.length() - 2);
                        System.out.println(toPrint);
                        break;
                    case "CLOSE GAME":
                        m_player.kill();
                        break;
                    default:
                        System.out.println("Command not valid, try again");
                }
            }
        }
        // closes scanner, make sure this line is at the end
        kb.close();
    }
}
