package main.java;

public abstract class FarmerDecorator extends Farmer {
    protected Farmer decoratedFarmer;

    public FarmerDecorator(Farmer decoratedFarmer) {
        this.decoratedFarmer = decoratedFarmer;
    }

    @Override
    public double cropAffinity() {
        return decoratedFarmer.cropAffinity;
    }

    @Override
    public double husbandryAffinity() {
        return decoratedFarmer.husbandryAffinity;
    }

    @Override
    public double profitAffinity() {
        return decoratedFarmer.profitAffinity;
    }

    @Override
    public String getName() {
        return decoratedFarmer.farmerName;
    }
}
