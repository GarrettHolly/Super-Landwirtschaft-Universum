package main.java;

import lombok.Getter;
import lombok.Setter;

public abstract class Animal {
    @Getter
    @Setter
    int age = 1;
    @Getter
    double affinity;

    public Animal() {

    }
}
