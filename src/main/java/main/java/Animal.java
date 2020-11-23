package main.java;

import lombok.Getter;
import lombok.Setter;

/**
 * This class allows for chicken, cow, and sheeps to be of type Animal for the
 * list of animals
 */
public abstract class Animal {

    /**
     * @return int
     * @return double
     */
    @Getter
    @Setter
    int age = 1;
    @Getter
    double affinity;

    public Animal() {

    }
}
