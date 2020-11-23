import java.util.Random;

/**
 * Getters for farmers base affinities.
 */
public abstract class Farmer {
    protected String farmerName;
    protected double cropAffinity;
    protected double husbandryAffinity;
    protected double profitAffinity;
    Random random;

    /**
     * Getter for crop affinity.
     * 
     * @return double
     */
    public double getCropAffinity() {
        double cropAffinityBase = Math.round(random.nextDouble()) + 2 * .25 + 2;
        return cropAffinityBase;
    }

    /**
     * Getter for husbandry affinity.
     * 
     * @return double
     */
    public double getHusbandryAffinity() {
        double husbandryAffinityBase = Math.round(random.nextDouble()) + 2 * .25 + 2;
        return husbandryAffinityBase;
    }

    /**
     * Getter for profit affinity.
     * 
     * @return double
     */
    public double getProfitAffinity() {
        double profitAffinityBase = Math.round(random.nextDouble()) + 2 * .25 + 2;
        return profitAffinityBase;
    }

    /**
     * Getter for farmer name.
     * 
     * @return String
     */
    public String getName() {
        return farmerName;
    }
}
