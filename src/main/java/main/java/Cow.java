package main.java;

import lombok.Getter;
import lombok.Setter;

public class Cow implements Animal {
    AnimalAffinity animalAffinity;
    @Getter
    double cowAffinity;
    @Getter
    @Setter
    int age;

    public Cow(AnimalAffinity animalAffinity) {
        this.animalAffinity = animalAffinity;
    }

    public void setAffinity() {
        cowAffinity = animalAffinity.getAffinity();
    }
}
