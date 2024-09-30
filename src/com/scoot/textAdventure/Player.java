package com.scoot.textAdventure;

import java.util.ArrayList;

public class Player {
    private final ArrayList<Item> m_inventory;
    private final ArrayList<Feat> m_feats;

    private CoordinatePair m_currentLocation;

    public Player(CoordinatePair defaultLocation) {
        m_currentLocation = defaultLocation;
        
        m_inventory = new ArrayList<Item>();
        m_feats = new ArrayList<Feat>();
    }

    /**
     * Moves the player to the destination by calling the relevant enter method
     * @param destLocation A CoordinatePair object containing the location that the player needs to move to
     * @return Whether the player failed to move to the destination
     */
    public boolean move(Location destLocation) {
        return destLocation.enter(this);
    }

    public boolean isAdjacent(CoordinatePair other) {
        int absoluteXDifference = Math.abs(m_currentLocation.getXCoordinate() - other.getXCoordinate());
        int absoluteYDifference = Math.abs(m_currentLocation.getYCoordinate() - other.getYCoordinate());
        return absoluteXDifference + absoluteYDifference == 1;
    }

    public CoordinatePair getCoordinates() {
        return m_currentLocation;
    }

    public void setCoordinates(CoordinatePair newCoordinates) {
        m_currentLocation = newCoordinates;
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
}