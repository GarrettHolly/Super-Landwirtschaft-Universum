package main.java;

public class CropAffinityFarmerDecorator extends FarmerDecorator {
    private final double affinityMultiplier = 3 + 1.5;

    public CropAffinityFarmerDecorator(Farmer decoratedFarmer) {
        super(decoratedFarmer);
    }

    /**
     * @return double
     */
    @Override
    public double getCropAffinity() {
        return decoratedFarmer.getCropAffinity() * affinityMultiplier;
    }
}
