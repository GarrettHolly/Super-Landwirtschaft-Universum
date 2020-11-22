package main.java;

public class Sheep implements Animal {
    AnimalAffinity animalAffinity;
    double sheepAffinity;
    int daysLeftUnitilHarvest;

    public Sheep(AnimalAffinity animalAffinity) {
        this.animalAffinity = animalAffinity;
    }

    /**
     * @return double
     */
    public void setAffinity() {
        sheepAffinity = animalAffinity.getAffinity();
    }
}
