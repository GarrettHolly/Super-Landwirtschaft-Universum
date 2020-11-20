package main.java;

import java.util.Random;

public class Sheep {

    public double getWoolAffinity() {
        Random random = new Random();
        double woolAffinityBase = Math.round(random.nextDouble()) + 2 * .25;
        return woolAffinityBase;
    }
}
