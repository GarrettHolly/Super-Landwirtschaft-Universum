package main.java;

import java.util.Random;

public class Chicken {

    public double getEggAffinity() {
        Random random = new Random();
        double eggAffinityBase = Math.round(random.nextDouble()) + 2 * .25;
        return eggAffinityBase;
    }
}
