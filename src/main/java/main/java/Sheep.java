package main.java;

import lombok.Getter;
import lombok.Setter;

public class Sheep extends Animal {
    @Getter
    BaseAnimalAffinity animalAffinity;;
    @Getter
    @Setter
    int age;

    public Sheep(BaseAnimalAffinity animalAffinity) {
        this.animalAffinity = animalAffinity;
    }

    public void setAffinity() {
        affinity = animalAffinity.getAffinity();
    }

    @Override
    public String toString() {
        return "Sheep";
    }

}
