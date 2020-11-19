package main.java;

public class EggAffinityAnimalDecorator extends AnimalDecorator {
    private final double affinityMultiplier = 2 + 1.5;

    public EggAffinityAnimalDecorator(Animal decoratedAnimal) {
        super(decoratedAnimal);
    }

    @Override
    public double getEggAffinity() {
        return decoratedAnimal.getEggAffinity() * affinityMultiplier;
    }
}
