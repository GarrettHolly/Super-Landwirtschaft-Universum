/**
 * Decorator to modify Farmer Affinities.
 */
public abstract class FarmerDecorator extends Farmer {
    protected Farmer decoratedFarmer;

    public FarmerDecorator(Farmer decoratedFarmer) {
        this.decoratedFarmer = decoratedFarmer;
    }

    /**
     * Getter for decorated crop affinity.
     * 
     * @return double
     */
    @Override
    public double getCropAffinity() {
        return decoratedFarmer.cropAffinity;
    }

    /**
     * Getter for decorated husbandry affinity.
     * 
     * @return double
     */
    @Override
    public double getHusbandryAffinity() {
        return decoratedFarmer.husbandryAffinity;
    }

    /**
     * Getter for decorated profit affinity.
     * 
     * @return double
     */
    @Override
    public double getProfitAffinity() {
        return decoratedFarmer.profitAffinity;
    }

    /**
     * Getter for decorated farmer name.
     * 
     * @return String
     */
    @Override
    public String getName() {
        return decoratedFarmer.farmerName;
    }
}
