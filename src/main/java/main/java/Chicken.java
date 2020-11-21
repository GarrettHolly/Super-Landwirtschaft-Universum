package main.java;

public abstract class Chicken {
    AnimalAffinity animalAffinity;
    int daysLeftUnitilHarvest;

    public Chicken(AnimalAffinity animalAffinity) {
        this.animalAffinity = animalAffinity;
    }

    /**
     * @return double
     */
    public double getAffinity() {
        return animalAffinity.getAffinity();
    }
}
