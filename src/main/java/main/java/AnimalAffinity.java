package main.java;

import java.util.Random;

public class AnimalAffinity {

    public double getAffinity() {
        Random random = new Random();
        double affinityBase = Math.round(random.nextDouble()) + 2 * .25;
        return affinityBase;
    }
}
