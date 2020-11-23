/**
 * Decorator for the Farmer class to modify Crop affinity.
 */
public class CropAffinityFarmerDecorator extends FarmerDecorator {
    private static final double affinityMultiplier = 3 + 1.5;

    public CropAffinityFarmerDecorator(Farmer decoratedFarmer) {
        super(decoratedFarmer);
    }

    /**
     * Getter for farmers crop affinity.
     * 
     * @return double
     */
    @Override
    public double getCropAffinity() {
        return decoratedFarmer.getCropAffinity() * affinityMultiplier;
    }
}
