package main.java;

import lombok.Getter;
import lombok.Setter;

public class Sheep implements Animal {
    AnimalAffinity animalAffinity;
    @Getter
    double sheepAffinity;
    @Getter
    @Setter
    int age;

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
