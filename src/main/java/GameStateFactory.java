
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GameStateFactory {

    Random random;

    /**
     * Factory to create different difficulty game modes.
     * 
     * @param gameMode
     * @param random
     */
    public GameStateFactory(Random random) {
        this.random = random;
    }

    public GameState getGameState(String gameMode) {
        FarmerFactory farmerFactory = new FarmerFactory();
        GameState gameState = new GameState();
        PurchaseCost purchaseCost = new PurchaseCost();

        gameState.setFarmer(farmerFactory.createFarmer(gameMode, random));
        gameState.setCurrentDay(1);
        gameState.setDayNightCycle(DayNightCycle.DAY);
        gameState.setAnimals(new HashMap<>());
        gameState.getAnimals().put("Chicken", new ArrayList<>());
        gameState.getAnimals().put("Cow", new ArrayList<>());
        gameState.getAnimals().put("Sheep", new ArrayList<>());
        int difficultyMultiplier = 1;

        if (gameMode.equalsIgnoreCase("Hard")) {
            difficultyMultiplier = 2;
        }
        gameState.setNumFarms(1);
        gameState.setNumHealthyCrops(25);
        gameState.setNumDiseasedCrops(0);
        gameState.setCurrentMoney(200);
        purchaseCost.setChickenCost(10 * difficultyMultiplier);
        purchaseCost.setCowCost(25 * difficultyMultiplier);
        purchaseCost.setSheepCost(35 * difficultyMultiplier);
        purchaseCost.setUpgradeFarmCost(1000 * difficultyMultiplier);
        gameState.setPurchaseCost(purchaseCost);
        return gameState;
    }
}
