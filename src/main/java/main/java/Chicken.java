package main.java;

public abstract class Chicken implements Animal {
    AnimalAffinity animalAffinity;
    double chickenAffinity;
    int daysLeftUnitilHarvest;

    public Chicken(AnimalAffinity animalAffinity) {
        this.animalAffinity = animalAffinity;
    }

    /**
     * @return double
     */
    public void setAffinity() {
        chickenAffinity = animalAffinity.getAffinity();
    }
}
