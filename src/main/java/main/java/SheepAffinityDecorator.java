package main.java;

public class SheepAffinityDecorator extends SheepDecorator {
    private final double affinityMultiplier = 3 + 1.5;

    public SheepAffinityDecorator(Sheep decoratedSheep) {
        super(decoratedSheep);
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
