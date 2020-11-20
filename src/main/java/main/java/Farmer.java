package main.java;

import java.util.Random;

public abstract class Farmer {
    protected String farmerName;
    protected double cropAffinity;
    protected double husbandryAffinity;
    protected double profitAffinity;
    Random random = new Random();

    public double getCropAffinity() {
        double cropAffinityBase = Math.round(random.nextDouble()) + 2 * .25;
        return cropAffinityBase;
    }

    public double getHusbandryAffinity() {
        double husbandryAffinityBase = Math.round(random.nextDouble()) + 2 * .25;
        return husbandryAffinityBase;
    }

    public double getProfitAffinity() {
        double profitAffinityBase = Math.round(random.nextDouble()) + 2 * .25;
        return profitAffinityBase;
    }

    public String getName() {
        return farmerName;
    }
}
