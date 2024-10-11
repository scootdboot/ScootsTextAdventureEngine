package com.scoot.textAdventure;

public class Feat {
    private final String m_description; // will never be displayed to the user
    private final int m_id;

    public Feat(String description, int id) {
        m_description = description;
        m_id = id;
    }

    public String getDescription() {
        return m_description;
    }

    public int getID() {
        return m_id;
    }

    @Override
    public String toString() {
        return "FEAT:\n" +
            "ID: " + m_id + "\n" +
            "DESCRIPTION: " + m_description;
    }
}