package main.java;

public class SheepAffinityDecorator extends SheepDecorator {
    private final double affinityMultiplier = 3 + 1.5;

    public SheepAffinityDecorator(Sheep decoratedSheep, AnimalAffinity animalAffinity) {
        super(decoratedSheep, animalAffinity);
    }

    /**
     * @return double
     */
    @Override
    public void setAffinity() {
        decoratedSheep.setAffinity();
        decoratedSheep.sheepAffinity *= affinityMultiplier;
    }
}
