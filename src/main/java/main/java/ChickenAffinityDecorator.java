package main.java;

public class ChickenAffinityDecorator extends ChickenDecorator {
    private final double affinityMultiplier = 3 + 1.5;

    public ChickenAffinityDecorator(Chicken decoratedChicken) {
        super(decoratedChicken);
    }

    @Override
    public void setAffinity() {
        decoratedChicken.setAffinity();
        decoratedChicken.chickenAffinity *= affinityMultiplier;
    }
}
