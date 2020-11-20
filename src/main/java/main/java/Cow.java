package main.java;

public class Cow {
    AnimalAffinity animalAffinity;
    int daysLeftUnitilHarvest;

    public Cow(AnimalAffinity animalAffinity) {
        this.animalAffinity = animalAffinity;
    }

    public double getAffinity() {
        return animalAffinity.getAffinity();
    }
}
