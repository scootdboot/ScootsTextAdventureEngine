package com.scoot.textAdventure;

import com.scoot.textAdventure.interactions.Interaction;

/**
 * This class should handle the game actually being played-the only file that should be directly modified.
 */
public class Game {
    private static Map m_map;
    private static Player m_player;

    // put code here to bulid map
    // THIS IS THE ONLY PLACE YOU SHOULD MODIFY m_map
    private static void loadMap() {
        Location[][] mapArray = new Location[1][1];
        /// use lambdas to define an EntranceInteraction and any Interactions used in it
        mapArray[0][0] = new Location(
            // EnterInteraction
            player -> {
                System.out.println("enter inital location");
                return true;
            }, 
            // rest of the Intearctions as parameters
            new Interaction("interact", player -> {
                System.out.println("interact!");
                return true;
            }));
        // create map object once all the Locations are defined
        m_map = new Map(mapArray, new CoordinatePair(0, 0), "MAP CREATED");
        System.out.println(m_map.getBootMessage());
        // create our player object
        m_player = new Player(m_map.getDefaultLocationCoordinates());
        // move them to the start location properly!
        movePlayer(m_player, m_map.getDefaultLocationCoordinates(), true);
    }

    /**
     * Tries to have the player enter the relevant location, returns whether it succeeds based on running the relevant entry method
     * @param player
     * @param destination
     * @param teleport Checks
     */
    public static boolean movePlayer(Player player, CoordinatePair destination, boolean teleport) {
        // null values are valid as Locations you can't access!
        if (m_map.getLocation(destination) == null) {
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
        loadMap();
        m_map.getLocation(m_player.getCoordinates()).tryInteraction(m_player, "interact");
    }
}
