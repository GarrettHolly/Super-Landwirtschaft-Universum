package main.java;

public class Sheep {
    AnimalAffinity animalAffinity;
    int daysLeftUnitilHarvest;

    public Sheep(AnimalAffinity animalAffinity) {
        this.animalAffinity = animalAffinity;
    }

    public double getAffinity() {
        return animalAffinity.getAffinity();
    }
}
