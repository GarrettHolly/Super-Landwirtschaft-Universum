package main.java;

public class MilkAffinityAnimalDecorator extends AnimalDecorator {
    private final double affinityMultiplier = 2 + 1.5;

    public MilkAffinityAnimalDecorator(Animal decoratedAnimal) {
        super(decoratedAnimal);
    }

    /**
     * @return double
     */
    @Override
    public double getMilkAffinity() {
        return decoratedAnimal.getMilkAffinity() * affinityMultiplier;
    }
}
