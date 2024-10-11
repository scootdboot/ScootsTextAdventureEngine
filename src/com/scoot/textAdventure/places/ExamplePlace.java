package com.scoot.textAdventure.places;

import com.scoot.textAdventure.interactions.Interaction;
import com.scoot.textAdventure.Place;
import com.scoot.textAdventure.Player;

/**
 * This is an example for how I'd recommend creating your locations - code your own classes that extend place with noarg constructors. The code seemes much
 * better organized this way, but there's no reason not to use Lambdas to define it in game other than code organization.
 */
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

    public ExamplePlace() {
        super(ExamplePlace::entranceInteraction, new ExampleInteraction());
    }
}