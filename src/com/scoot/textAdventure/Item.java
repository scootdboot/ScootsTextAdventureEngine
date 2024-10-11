package com.scoot.textAdventure;

public class Item {
    private final String m_name;
    private final String m_description;
    private final int m_id;

    public Item(String name, String description, int id) {
        m_name = name;
        m_description = description;
        m_id = id;
    }

    public String getName() {
        return m_name;
    }

    public String getDescription() {
        return m_description;
    }

    public int getID() {
        return m_id;
    }

    @Override
    public String toString() {
        return "ITEM:\n" +
            "Name: " + m_name + "\n" +
            "Description: " + m_description + "\n" +
            "ID: " + m_id;
    }
}
