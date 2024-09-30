package com.scoot.textAdventure;

import java.util.HashMap;

import com.scoot.textAdventure.interactions.EntranceInteraction;
import com.scoot.textAdventure.interactions.Interaction;

public class Location {
    private final EntranceInteraction k_entryInteraction;
    private final HashMap<String, Interaction> k_interactions;

    public Location(EntranceInteraction entryInteraction, Interaction...interactions) {
        k_entryInteraction = entryInteraction;

        k_interactions = new HashMap<String, Interaction>();
        for (int i = 0; i < interactions.length; i++) {
            k_interactions.put(interactions[i].getCommand(), interactions[i]);
        }
    }

    public boolean enter(Player player) {
        return k_entryInteraction.enter(player);
    }

    public boolean tryInteraction(Player player, String command) {
        if (k_interactions.get(command) == null) {
            return false;
        }
        return k_interactions.get(command).getInteractionFunction().tryInteraction(player);
    }
}