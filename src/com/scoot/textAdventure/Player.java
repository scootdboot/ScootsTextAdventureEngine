package com.scoot.textAdventure;

import java.awt.Point;
import java.util.ArrayList;

public class Player {
    private final ArrayList<Item> m_inventory;
    private final ArrayList<Feat> m_feats;

    private Point m_currentLocation;
    private boolean m_alive;

    public Player(Point defaultLocation) {
        m_inventory = new ArrayList<Item>();
        m_feats = new ArrayList<Feat>();

        m_currentLocation = defaultLocation;
        m_alive = true;
    }

    /**
     * Moves the player to the destination by calling the relevant enter method
     * @param destPlace A Place object containing the location that the player needs to move to
     * @return Whether the player succeeded in trying to move to destination
     */
    public boolean move(Place destPlace) {
        return destPlace.enter(this);
    }

    public Point getCoordinates() {
        return m_currentLocation;
    }

    public void addItem(Item item) {
        m_inventory.add(item);
    }

    public boolean removeItem(Item item) {
        return m_inventory.remove(item);
    }

    public void addFeat(Feat feat) {
        m_feats.add(feat);
    }

    public boolean removeFeat(Feat feat) {
        return m_feats.remove(feat);
    }

    public boolean hasFeat(int id) {
        for (int i = 0; i < m_feats.size(); i++) {
            if (m_feats.get(i).getID() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean hasItem(int id) {
        for (int i = 0; i < m_inventory.size(); i++) {
            if (m_inventory.get(i).getID() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Kills the player, which should end the game and give the user the opportunity to restart
     */
    public void kill() {
        m_alive = false;
    }

    /**
     * @return Whether the player is currently alive
     */
    public boolean isAlive() {
        return m_alive;
    }
}