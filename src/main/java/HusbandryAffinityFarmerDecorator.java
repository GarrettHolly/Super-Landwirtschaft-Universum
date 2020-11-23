/**
 * Decorator for the Farmer class to modify Husbandry affinity.
 */
public class HusbandryAffinityFarmerDecorator extends FarmerDecorator {

    private static final double affinityMultiplier = 3 + 1.5;

    public HusbandryAffinityFarmerDecorator(Farmer decoratedFarmer) {
        super(decoratedFarmer);
    }

    /**
     * Getter for decorated husbandry affinity.
     * 
     * @return double
     */
    @Override
    public double getHusbandryAffinity() {
        return decoratedFarmer.getHusbandryAffinity() * affinityMultiplier;
    }
}
