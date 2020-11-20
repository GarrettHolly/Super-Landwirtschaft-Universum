package main.java;

import java.util.Random;

public abstract class Animal {
    protected String animalType;
    protected double milkAffinity;
    protected double woolAffinity;
    protected double eggAffinity;

    /**
     * @return double
     */
    public double getMilkAffinity() {
        Random random = new Random();
        double milkAffinityBase = Math.round(random.nextDouble()) + 2 * .25;
        return milkAffinityBase;
    }

    /**
     * @return double
     */
    public double getWoolAffinity() {
        Random random = new Random();
        double woolAffinityBase = Math.round(random.nextDouble()) + 2 * .25;
        return woolAffinityBase;
    }

    /**
     * @return double
     */
    public double getEggAffinity() {
        Random random = new Random();
        double eggAffinityBase = Math.round(random.nextDouble()) + 2 * .25;
        return eggAffinityBase;
    }

    /**
     * @return String
     */
    public String getAnimalType() {
        return animalType;
    }
}
