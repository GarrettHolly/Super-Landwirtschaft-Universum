package main.java;

import java.util.Random;

public class Cow {

    public double getMilkAffinity() {
        Random random = new Random();
        double milkAffinityBase = Math.round(random.nextDouble()) + 2 * .25;
        return milkAffinityBase;
    }
}
