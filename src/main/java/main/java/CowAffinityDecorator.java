package main.java;

public class CowAffinityDecorator extends CowDecorator {
    private final double affinityMultiplier = 3 + 1.5;

    public CowAffinityDecorator(Cow decoratedCow, AnimalAffinity animalAffinity) {
        super(decoratedCow, animalAffinity);
    }

    @Override
    public void setAffinity() {
        decoratedCow.setAffinity();
        decoratedCow.cowAffinity *= affinityMultiplier;
    }
}
