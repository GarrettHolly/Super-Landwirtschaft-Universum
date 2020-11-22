package main.java;

import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class GameState {

    private int numFarms;
    private int numHealthyCrops;
    private int numDiseasedCrops;
    private double currentMoney;
    private Farmer farmer;
    private PurchaseCost purchaseCost;
    private int currentDay;
    private DayNightCycle dayNightCycle;
    private Map<String, List<Animal>> animals;
}
