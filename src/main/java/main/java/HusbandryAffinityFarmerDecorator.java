package main.java;

public class HusbandryAffinityFarmerDecorator extends FarmerDecorator {

    private final double affinityMultiplier = 2 + 1.5;

    public HusbandryAffinityFarmerDecorator(Farmer decoratedFarmer) {
        super(decoratedFarmer);
    }

    @Override
    public double getHusbandryAffinity() {
        return decoratedFarmer.getHusbandryAffinity() * affinityMultiplier;
    }
}
