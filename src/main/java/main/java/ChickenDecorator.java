package main.java;

public abstract class ChickenDecorator implements Animal {
    protected Chicken decoratedChicken;

    public ChickenDecorator(Chicken decoratedChicken) {
        this.decoratedChicken = decoratedChicken;
    }

    public void setAffinity() {
        decoratedChicken.setAffinity();
    }
}
