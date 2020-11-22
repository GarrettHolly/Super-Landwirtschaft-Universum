package main.java;

import lombok.Getter;
import lombok.Setter;

public class Cow extends Animal {
    @Getter
    BaseAnimalAffinity animalAffinity;
    @Getter
    @Setter
    int age;

    public Cow(BaseAnimalAffinity animalAffinity) {
        this.animalAffinity = animalAffinity;
    }

    public void setAffinity() {
        affinity = animalAffinity.getAffinity();
    }

    @Override
    public String toString() {
        return "Cow";
    }
}
