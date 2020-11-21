package main.java;

public class SheepAffinityDecorator extends SheepDecorator {
    private final double affinityMultiplier = 2 + 1.5;

    public SheepAffinityDecorator(Sheep decoratedSheep, AnimalAffinity animalAffinity) {
        super(decoratedSheep, animalAffinity);
    }

    /**
     * @return double
     */
    @Override
    public double getAffinity() {
        return decoratedSheep.getAffinity() * affinityMultiplier;
    }
}
