package com.scoot.textAdventure;

public class Item {
    private final String k_name;
    private final String k_description;
    private final int k_id;

    public Item(String name, String description, int id) {
        k_name = name;
        k_description = description;
        k_id = id;
    }

    public String getName() {
        return k_name;
    }

    public String getDescription() {
        return k_description;
    }

    public int getID() {
        return k_id;
    }

    @Override
    public String toString() {
        return "ITEM:\n" +
            "Name: " + k_name + "\n" +
            "Description: " + k_description + "\n" +
            "ID: " + k_id;
    }
}
