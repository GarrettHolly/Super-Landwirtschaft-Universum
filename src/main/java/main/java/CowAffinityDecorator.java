package main.java;

public class CowAffinityDecorator extends CowDecorator {
    private final double affinityMultiplier = 2 + 1.5;

    public CowAffinityDecorator(Cow decoratedCow, AnimalAffinity animalAffinity) {
        super(decoratedCow, animalAffinity);
    }

    /**
     * @return double
     */
    @Override
    public double getAffinity() {
        return decoratedCow.getAffinity() * affinityMultiplier;
    }
}
