package main.java;

public abstract class ChickenDecorator extends Chicken {
    protected Chicken decoratedChicken;

    public ChickenDecorator(Chicken decoratedChicken, AnimalAffinity animalAffinity) {
        super(animalAffinity);
        this.decoratedChicken = decoratedChicken;
    }

    @Override
    public double getAffinity() {
        return decoratedChicken.getAffinity();
    }
}
