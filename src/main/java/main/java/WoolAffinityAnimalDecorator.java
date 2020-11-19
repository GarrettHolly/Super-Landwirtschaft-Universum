package main.java;

public class WoolAffinityAnimalDecorator extends AnimalDecorator {
    private final double affinityMultiplier = 2 + 1.5;

    public WoolAffinityAnimalDecorator(Animal decoratedAnimal) {
        super(decoratedAnimal);
    }

    @Override
    public double getWoolAffinity() {
        return decoratedAnimal.getWoolAffinity() * affinityMultiplier;
    }
}
