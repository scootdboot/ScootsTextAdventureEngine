package com.scoot.textAdventure;

public class CoordinatePair {
    private final int m_xCoordinate;
    private final int m_yCoordinate;

    /**
     * @param xCoordinate > 0
     * @param yCoordinate > 0
     */
    public CoordinatePair(int xCoordinate, int yCoordinate) {
        m_xCoordinate = xCoordinate;
        m_yCoordinate = yCoordinate;
    }

    public int getXCoordinate() {
        return m_xCoordinate;
    }

    public int getYCoordinate() {
        return m_yCoordinate;
    }

    public boolean equals(CoordinatePair other) {
        return m_xCoordinate == other.m_xCoordinate && m_yCoordinate == other.m_yCoordinate;
    }
}
