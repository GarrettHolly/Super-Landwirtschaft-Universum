package main.java;

import lombok.Data;

@Data
public class GameState {

    private int numFarms;
    private int numHealthyCrops;
    private int numDiseasedCrops;
    private Farmer farmer;
    // private DayNightCycle dayNightCycle;
    // private Map<String, List<Animal>> animals;
}
