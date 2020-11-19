package main.java;

import java.util.Random;

public abstract class Animal {
    protected String animalType;
    protected double milkAffinity;
    protected double woolAffinity;
    protected double eggAffinity;

    public double getMilkAffinity() {
        Random random = new Random();
        double milkAffinityBase = Math.round(random.nextDouble()) + 2 * .25;
        return milkAffinityBase;
    }

    public double getWoolAffinity() {
        Random random = new Random();
        double woolAffinityBase = Math.round(random.nextDouble()) + 2 * .25;
        return woolAffinityBase;
    }

    public double getEggAffinity() {
        Random random = new Random();
        double eggAffinityBase = Math.round(random.nextDouble()) + 2 * .25;
        return eggAffinityBase;
    }

    public String getAnimalType() {
        return animalType;
    }
}
