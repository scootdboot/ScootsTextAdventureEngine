package com.scoot.textAdventure;

import java.awt.Point;

public class Map {
    private final Place[][] k_map;
    private final Point k_defaultLocation;

    private final String k_bootMessage;

    public Map(Place[][] map, Point defaultLocation, String bootMessage) {
        k_map = map;
        k_defaultLocation = defaultLocation;
        k_bootMessage = bootMessage;
    }

    public Point getDefaultLocationCoordinates() {
        return k_defaultLocation;
    }

    public Place getPlace(Point point) {
        return k_map[(int) point.getY()][(int) point.getX()];
    }

    public String getBootMessage() {
        return k_bootMessage;
    }
}