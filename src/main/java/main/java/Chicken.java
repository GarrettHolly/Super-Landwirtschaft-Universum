package main.java;

import lombok.Getter;
import lombok.Setter;

public class Chicken implements Animal {
    AnimalAffinity animalAffinity;
    @Getter
    double chickenAffinity;
    @Getter
    @Setter
    int age;

    public Chicken(AnimalAffinity animalAffinity) {
        this.animalAffinity = animalAffinity;
    }

    public void setAffinity() {
        chickenAffinity = animalAffinity.getAffinity();
    }
}
