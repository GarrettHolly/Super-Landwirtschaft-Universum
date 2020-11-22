package main.java;

public abstract class ChickenDecorator extends Animal {
    protected Chicken decoratedChicken;

    public ChickenDecorator(Chicken decoratedChicken) {
        this.decoratedChicken = decoratedChicken;
    }

    public void setAffinity() {
        decoratedChicken.setAffinity();
    }

    public double getAffinity() {
        return decoratedChicken.getAffinity();
    }

    @Override
    public String toString() {
        return decoratedChicken.toString();
    }
}
