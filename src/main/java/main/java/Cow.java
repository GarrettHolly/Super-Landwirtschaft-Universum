package main.java;

public class Cow implements Animal {
    AnimalAffinity animalAffinity;
    double cowAffinity;
    int daysLeftUnitilHarvest;

    public Cow(AnimalAffinity animalAffinity) {
        this.animalAffinity = animalAffinity;
    }

    /**
     * @return double
     */
    public void setAffinity() {
        cowAffinity = animalAffinity.getAffinity();
    }
}
