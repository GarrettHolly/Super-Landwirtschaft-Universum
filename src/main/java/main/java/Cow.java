package main.java;

import lombok.Getter;

public class Cow implements Animal {
    AnimalAffinity animalAffinity;
    @Getter
    double cowAffinity;
    int daysLeftUnitilHarvest;

    public Cow(AnimalAffinity animalAffinity) {
        this.animalAffinity = animalAffinity;
    }

    public void setAffinity() {
        cowAffinity = animalAffinity.getAffinity();
    }
}
