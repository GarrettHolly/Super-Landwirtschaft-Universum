import java.util.List;
import java.util.Map;
import lombok.Data;

/**
 * This class is used for updating the games state throughout gameplay.
 * 
 * @return int
 * @return int
 * @return int
 * @return double
 * @return Farmer
 * @return PurchaseCost
 * @return int
 * @return DayNightCycle
 * @return Map<String, List<Animal>>
 * @return boolean
 * @return boolean
 * @return int
 * @return String
 */
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
