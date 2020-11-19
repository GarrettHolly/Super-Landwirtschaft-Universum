package main.java;

public class CropAffinityFarmerDecorator extends FarmerDecorator {
    private final double affinityMultiplier = 2 + 1.5;

    public CropAffinityFarmerDecorator(Farmer decoratedFarmer) {
        super(decoratedFarmer);
    }

    @Override
    public double cropAffinity() {
        return decoratedFarmer.cropAffinity() * affinityMultiplier;
    }
}