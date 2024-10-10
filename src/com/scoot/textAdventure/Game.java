package com.scoot.textAdventure;

import java.awt.Point;
import java.util.Scanner;

import com.scoot.textAdventure.places.*;

/**
 * This class should handle the game actually being played-the only others files that should get modified are in the places package
 */
public class Game {
    private static Map m_map;
    private static Player m_player;

    // put code here to bulid map
    // THIS IS THE ONLY PLACE YOU SHOULD MODIFY m_map
    private static void loadMap() {
        Place[][] mapArray = new Place[1][1];
        /// create Place classes to define each location if you want it to be more encapsulated
        mapArray[0][0] = new ExamplePlace(m_player);
        // create map object once all the Places are defined
        m_map = new Map(mapArray, new Point(0, 0), "MAP CREATED");
        System.out.println(m_map.getBootMessage());
        // create our player object
        Point mapDefaultCoordinates = m_map.getDefaultLocationCoordinates();
        m_player = new Player(mapDefaultCoordinates);
        // move them to the start Place properly!
        movePlayer(m_player, mapDefaultCoordinates, true);
    }

    /**
     * Tries to have the player enter the relevant Place, returns whether it succeeds based on running the relevant entry method
     * @param player
     * @param destination
     * @param teleport Determines whether the code should check if the player is adjacent before allowing the move
     */
    public static boolean movePlayer(Player player, Point destination, boolean teleport) {
        // null values are valid as Place you can't access!
        // but also account for the fact that the way it is someone might accidentally try and move off the map
        try {
            if (m_map.getPlace(destination) == null) {
                System.out.println("You find yourself unable to move in that direction");
                return false;
            }
        } catch (Exception e) {
            System.out.println("You find yourself unable to move in that direction");
            return false;
        }

        // beyond this point let the entry method for whatever place handle printing to the console
        if (player.move(m_map.getPlace(destination))) {
            player.getCoordinates().setLocation(destination);
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
            System.out.print("> ");
            input = kb.nextLine();
            if (input.isEmpty()) {
                continue;
            }
        }
        // closes scanner, make sure this line is at the end
        kb.close();
    }
}
