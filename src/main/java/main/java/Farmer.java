package main.java;

import java.util.Random;

public abstract class Farmer {
    protected String farmerName;
    protected double cropAffinity;
    protected double husbandryAffinity;
    protected double profitAffinity;

    public double getCropAffinity() {
        Random random = new Random();
        double cropAffinityBase = Math.round(random.nextDouble()) + 2 * .25;
        return cropAffinityBase;
    }

    public double getHusbandryAffinity() {
        Random random = new Random();
        double husbandryAffinityBase = Math.round(random.nextDouble()) + 2 * .25;
        return husbandryAffinityBase;
    }

    public double getProfitAffinity() {
        Random random = new Random();
        double profitAffinityBase = Math.round(random.nextDouble()) + 2 * .25;
        return profitAffinityBase;
    }

    public String getName() {
        return farmerName;
    }
}
