package main.java;

import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class GameState {

    private int numFarms = 1;
    private int numHealthyCrops;
    private int numDiseasedCrops;
    private double currentMoney;
    private TasksCurrency incomeCurrency;
    private Farmer farmer;
    private DayNightCycle dayNightCycle;
    private Map<String, List<Animal>> animals;
}
