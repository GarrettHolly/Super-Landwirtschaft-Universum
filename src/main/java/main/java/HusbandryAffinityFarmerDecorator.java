package main.java;

/**
 * Decorator for the Farmer class to modify Husbandry affinity
 */
public class HusbandryAffinityFarmerDecorator extends FarmerDecorator {

    private final double affinityMultiplier = 3 + 1.5;

    public HusbandryAffinityFarmerDecorator(Farmer decoratedFarmer) {
        super(decoratedFarmer);
    }

    /**
     * @return double
     */
    @Override
    public double getHusbandryAffinity() {
        return decoratedFarmer.getHusbandryAffinity() * affinityMultiplier;
    }
}
