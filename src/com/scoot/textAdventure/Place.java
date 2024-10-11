package com.scoot.textAdventure;

import java.util.Collection;
import java.util.HashMap;

import com.scoot.textAdventure.interactions.EntranceInteraction;
import com.scoot.textAdventure.interactions.Interaction;

/**
 * The literal Places that exist in a Map. They are NOT coordinate pairs, they actually contain Interactions
 */
public class Place {
    private final EntranceInteraction m_entryInteraction;
    private final HashMap<String, Interaction> m_interactions;

    public Place(EntranceInteraction entryInteraction, Interaction...interactions) {
        m_entryInteraction = entryInteraction;

        m_interactions = new HashMap<String, Interaction>();
        for (int i = 0; i < interactions.length; i++) {
            m_interactions.put(interactions[i].getCommand(), interactions[i]);
        }
    }

    public final Collection<Interaction> getInteractions() {
        return m_interactions.values();
    }

    /**
     * Method just uses the EntryInteraction in this Place to determine if the player is allowed to enter here.
     * @param player
     * @return Whether the entry succeeds
     */
    public final boolean enter(Player player) {
        return m_entryInteraction.enter(player);
    }

    /**
     * Polls the list of Interactions to determine if an Interaction should occur.
     * @param player
     * @param command This is literally what should be entered by the player to trigger the Interaction
     * @return Returns false if the Interaction is not found or if the Interaction fails, returns true if the Interaction is found and succeeds
     */
    public final boolean tryInteraction(Player player, String command) {
        if (m_interactions.get(command) == null) {
            return false;
        }
        return m_interactions.get(command).getInteractionFunction().tryInteraction(player);
    }
}