package main.java;

import java.util.Random;

public abstract class Farmer {
    protected String farmerName;
    protected double cropAffinity;
    protected double husbandryAffinity;
    protected double profitAffinity;
    Random random;

    /**
     * @return double
     */
    public double getCropAffinity() {
        double cropAffinityBase = Math.round(random.nextDouble()) + 2 * .25 + 2;
        return cropAffinityBase;
    }

    /**
     * @return double
     */
    public double getHusbandryAffinity() {
        double husbandryAffinityBase = Math.round(random.nextDouble()) + 2 * .25 + 2;
        return husbandryAffinityBase;
    }

    /**
     * @return double
     */
    public double getProfitAffinity() {
        double profitAffinityBase = Math.round(random.nextDouble()) + 2 * .25 + 2;
        return profitAffinityBase;
    }

    /**
     * @return String
     */
    public String getName() {
        return farmerName;
    }
}
