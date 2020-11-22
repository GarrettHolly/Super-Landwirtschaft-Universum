package main.java;

public class SheepDecorator extends Sheep {
    protected Sheep decoratedSheep;

    public SheepDecorator(Sheep decoratedSheep, AnimalAffinity animalAffinity) {
        super(animalAffinity);
        this.decoratedSheep = decoratedSheep;
    }

    @Override
    public void setAffinity() {
        decoratedSheep.setAffinity();
    }
}