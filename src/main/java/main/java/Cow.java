package main.java;

public class Cow implements Animal {
    AnimalAffinity animalAffinity;
    int daysLeftUnitilHarvest;

    public Cow(AnimalAffinity animalAffinity) {
        this.animalAffinity = animalAffinity;
    }

    /**
     * @return double
     */
    public double getAffinity() {
        return animalAffinity.getAffinity();
    }
}
