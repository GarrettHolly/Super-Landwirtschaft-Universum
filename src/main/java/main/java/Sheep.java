package main.java;

import lombok.Getter;

public class Sheep implements Animal {
    AnimalAffinity animalAffinity;
    @Getter
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
