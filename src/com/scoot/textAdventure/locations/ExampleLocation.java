package com.scoot.textAdventure.locations;

import com.scoot.textAdventure.interactions.Interaction;
import com.scoot.textAdventure.Location;
import com.scoot.textAdventure.Player;

public class ExampleLocation extends Location {
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

    public ExampleLocation(Player player) {
        super(ExampleLocation::entranceInteraction, new ExampleInteraction());
    }
}