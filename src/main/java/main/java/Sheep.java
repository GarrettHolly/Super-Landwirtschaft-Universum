package main.java;

public class Sheep {
    AnimalAffinity animalAffinity;
    int daysLeftUnitilHarvest;

    public Sheep(AnimalAffinity animalAffinity) {
        this.animalAffinity = animalAffinity;
    }

    /**
     * @return double
     */
    public double getAffinity() {
        return animalAffinity.getAffinity();
    }
}