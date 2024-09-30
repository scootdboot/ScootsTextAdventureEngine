package com.scoot.textAdventure.interactions;

public class Interaction {
    private final String k_command;
    private final InteractionFunction k_interactionFunction;

    public Interaction(String command, InteractionFunction interactionFunction) {
        k_command = command;
        k_interactionFunction = interactionFunction;
    }

    public String getCommand() {
        return k_command;
    }

    public InteractionFunction getInteractionFunction() {
        return k_interactionFunction;
    }
}
