package main.java;

public class Chicken {
    AnimalAffinity animalAffinity;
    int daysLeftUnitilHarvest;

    public Chicken(AnimalAffinity animalAffinity) {
        this.animalAffinity = animalAffinity;
    }

    public double getAffinity() {
        return animalAffinity.getAffinity();
    }
}
