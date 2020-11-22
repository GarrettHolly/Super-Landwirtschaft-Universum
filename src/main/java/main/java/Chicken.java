package main.java;

import lombok.Getter;

public class Chicken implements Animal {
    AnimalAffinity animalAffinity;
    @Getter
    double chickenAffinity;
    int daysLeftUnitilHarvest;

    public Chicken(AnimalAffinity animalAffinity) {
        this.animalAffinity = animalAffinity;
    }

    public void setAffinity() {
        chickenAffinity = animalAffinity.getAffinity();
    }
}
