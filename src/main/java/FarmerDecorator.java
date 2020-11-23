/**
 * Decorator to modify Farmer Affinities
 */
public abstract class FarmerDecorator extends Farmer {
    protected Farmer decoratedFarmer;

    public FarmerDecorator(Farmer decoratedFarmer) {
        this.decoratedFarmer = decoratedFarmer;
    }

    /**
     * @return double
     */
    @Override
    public double getCropAffinity() {
        return decoratedFarmer.cropAffinity;
    }

    /**
     * @return double
     */
    @Override
    public double getHusbandryAffinity() {
        return decoratedFarmer.husbandryAffinity;
    }

    /**
     * @return double
     */
    @Override
    public double getProfitAffinity() {
        return decoratedFarmer.profitAffinity;
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return decoratedFarmer.farmerName;
    }
}
