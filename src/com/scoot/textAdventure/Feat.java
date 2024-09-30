package com.scoot.textAdventure;

public class Feat {
    private final String k_description; // will never be displayed to the user
    private final int k_id;

    public Feat(String description, int id) {
        k_description = description;
        k_id = id;
    }

    public String getDescription() {
        return k_description;
    }

    public int getID() {
        return k_id;
    }

    @Override
    public String toString() {
        return "FEAT:\n" +
            "ID: " + k_id + "\n" +
            "DESCRIPTION: " + k_description;
    }
}