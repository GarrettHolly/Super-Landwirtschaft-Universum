package main.java;

public class ProfitAffinityFarmerDecorator extends FarmerDecorator {
    private final double affinityMultiplier = 3 + 1.5;

    public ProfitAffinityFarmerDecorator(Farmer decoratedFarmer) {
        super(decoratedFarmer);
    }

    /**
     * @return double
     */
    @Override
    public double getProfitAffinity() {
        return decoratedFarmer.getProfitAffinity() * affinityMultiplier;
    }
}
