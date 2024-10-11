package com.scoot.textAdventure;

import java.awt.Point;

public class Map {
    private final Place[][] m_map;
    private final Point m_defaultLocation;

    private final String m_bootMessage;

    public Map(Place[][] map, Point defaultLocation, String bootMessage) {
        m_map = map;
        m_defaultLocation = defaultLocation;
        m_bootMessage = bootMessage;
    }

    public Point getDefaultLocationCoordinates() {
        return m_defaultLocation;
    }

    public Place getPlace(Point point) {
        return m_map[(int) point.getY()][(int) point.getX()];
    }

    public String getBootMessage() {
        return m_bootMessage;
    }
}