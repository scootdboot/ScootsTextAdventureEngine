package com.scoot.textAdventure.interactions;

public class Interaction {
    private final String m_command;
    private final InteractionFunction m_interactionFunction;

    public Interaction(String command, InteractionFunction interactionFunction) {
        m_command = command;
        m_interactionFunction = interactionFunction;
    }

    public String getCommand() {
        return m_command;
    }

    public InteractionFunction getInteractionFunction() {
        return m_interactionFunction;
    }
}
