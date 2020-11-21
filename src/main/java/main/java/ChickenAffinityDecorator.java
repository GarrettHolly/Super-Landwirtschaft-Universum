package main.java;

public class ChickenAffinityDecorator extends ChickenDecorator {
    private final double affinityMultiplier = 2 + 1.5;

    public ChickenAffinityDecorator(Chicken decoratedChicken, AnimalAffinity animalAffinity) {
        super(decoratedChicken, animalAffinity);
    }

    /**
     * @return double
     */
    @Override
    public double getAffinity() {
        return decoratedChicken.getAffinity() * affinityMultiplier;
    }
}
