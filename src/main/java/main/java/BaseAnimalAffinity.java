package main.java;

import java.util.Random;

public class BaseAnimalAffinity {
    Random random;

    public BaseAnimalAffinity(Random random) {
        this.random = random;
    }

    /**
     * @return double
     */
    public double getAffinity() {
        double affinityBase = Math.round(random.nextDouble()) + 2 * .25;
        return affinityBase;
    }
}
