/**
 * Decorator for the Farmer class to modify Profit affinity.
 */
public class ProfitAffinityFarmerDecorator extends FarmerDecorator {
    private static final double affinityMultiplier = 3 + 1.5;

    public ProfitAffinityFarmerDecorator(Farmer decoratedFarmer) {
        super(decoratedFarmer);
    }

    /**
     * Getter for decorated profit affinity.
     * 
     * @return double
     */
    @Override
    public double getProfitAffinity() {
        return decoratedFarmer.getProfitAffinity() * affinityMultiplier;
    }
}
