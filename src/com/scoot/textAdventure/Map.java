package com.scoot.textAdventure;

public class Map {
    private final Location[][] k_map;
    private final CoordinatePair k_defaultLocation;

    private final String k_bootMessage;

    public Map(Location[][] map, CoordinatePair defaultLocation, String bootMessage) {
        k_map = map;
        k_defaultLocation = defaultLocation;
        k_bootMessage = bootMessage;
    }

    public CoordinatePair getDefaultLocationCoordinates() {
        return k_defaultLocation;
    }

    public Location getLocation(CoordinatePair coordinatePair) {
        return k_map[coordinatePair.getYCoordinate()][coordinatePair.getXCoordinate()];
    }

    public String getBootMessage() {
        return k_bootMessage;
    }
}