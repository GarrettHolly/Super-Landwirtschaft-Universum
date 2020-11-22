package main.java;

public class SheepDecorator extends Animal {
    protected Sheep decoratedSheep;

    public SheepDecorator(Sheep decoratedSheep) {
        this.decoratedSheep = decoratedSheep;
    }

    public void setAffinity() {
        decoratedSheep.setAffinity();
    }

    public double getAffinity() {
        return decoratedSheep.getAffinity();
    }

    @Override
    public String toString() {
        return decoratedSheep.toString();
    }
}
