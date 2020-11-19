package main.java;

public abstract class FarmerDecorator extends Farmer {
    protected Farmer decoratedFarmer;

    public FarmerDecorator(Farmer decoratedFarmer) {
        this.decoratedFarmer = decoratedFarmer;
    }

    @Override
    public double getCropAffinity() {
        return decoratedFarmer.cropAffinity;
    }

    @Override
    public double getHusbandryAffinity() {
        return decoratedFarmer.husbandryAffinity;
    }

    @Override
    public double getProfitAffinity() {
        return decoratedFarmer.profitAffinity;
    }

    @Override
    public String getName() {
        return decoratedFarmer.farmerName;
    }
}
