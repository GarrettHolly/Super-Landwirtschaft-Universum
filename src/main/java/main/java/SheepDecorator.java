package main.java;

public class SheepDecorator implements Animal {
    protected Sheep decoratedSheep;

    public SheepDecorator(Sheep decoratedSheep) {
        this.decoratedSheep = decoratedSheep;
    }

    public void setAffinity() {
        decoratedSheep.setAffinity();
    }
}
