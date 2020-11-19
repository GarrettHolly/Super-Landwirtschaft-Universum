package main.java;

public class ProfitAffinityFarmerDecorator extends FarmerDecorator {
    private final double affinityMultiplier = 2 + 1.5;

    public ProfitAffinityFarmerDecorator(Farmer decoratedFarmer) {
        super(decoratedFarmer);
    }

    @Override
    public double profitAffinity() {
        return decoratedFarmer.husbandryAffinity() * affinityMultiplier;
    }
}
