package com.scoot.textAdventure.places;

import com.scoot.textAdventure.interactions.Interaction;
import com.scoot.textAdventure.Place;
import com.scoot.textAdventure.Player;

public class ExamplePlace extends Place {
    private static boolean entranceInteraction(Player player) {
        System.out.println("enter initial location");
        return true;
    }

    public static class ExampleInteraction extends Interaction {
        private static boolean exampleInteraction(Player player) {
            System.out.println("Interacted!");
            return true;
        }

        public ExampleInteraction() {
            super("interact", ExampleInteraction::exampleInteraction);
        }
    }

    public ExamplePlace(Player player) {
        super(ExamplePlace::entranceInteraction, new ExampleInteraction());
    }
}