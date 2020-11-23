
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class GameLoopTest {

    GameLoop gameLoop;
    GameState easyGameState;
    BaseAnimalAffinity animalAffinity;
    @Mock
    Random random;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() {

        TasksCurrency incomeCurrency = new TasksCurrency();
        animalAffinity = new BaseAnimalAffinity(random);
        Subject diseasedCrop = new Subject();
        Subject sheepSubject = new Subject();
        Subject cowSubject = new Subject();
        Subject chickenSubject = new Subject();
        new DiseasedCropDisplay(diseasedCrop);
        new SheepPurchaseDisplay(sheepSubject);
        new CowPurchaseDisplay(cowSubject);
        new ChickenPurchaseDisplay(chickenSubject);
        when(random.nextDouble()).thenReturn(0.0);
        GameStateFactory gameStateFactory = new GameStateFactory(random);
        easyGameState = gameStateFactory.getGameState("Easy");
        diseasedCrop.setState(easyGameState);
        sheepSubject.setState(easyGameState);
        cowSubject.setState(easyGameState);
        chickenSubject.setState(easyGameState);
        @SuppressWarnings("all")
        Map<String, Subject> subjects = new HashMap<>() {
            {
                put("diseasedCrop", diseasedCrop);
                put("sheepSubject", sheepSubject);
                put("cowSubject", cowSubject);
                put("chickenSubject", chickenSubject);
            }
        };

        gameLoop = new GameLoop(easyGameState, random, incomeCurrency, animalAffinity, subjects);

    }

    /**
     * Uses the predatorattackcropcheck() to return the number of healthy crops.
     */
    @Test
    public void predatorAttackCropTestShouldRemoveOneCrop() {
        when(random.nextDouble()).thenReturn(1.0).thenReturn(0.0);
        gameLoop.predatorAttackCropCheck();
        assertEquals(easyGameState.getNumHealthyCrops(), 24);
    }

    /**
     * Uses the predatorAttackCropCheck() to remove multiple healthy crops.
     */
    @Test
    public void predatorAttackCropTestShouldRemoveTwoCrops() {
        when(random.nextDouble()).thenReturn(1.0).thenReturn(1.0).thenReturn(1.0).thenReturn(0.0);
        gameLoop.predatorAttackCropCheck();
        assertEquals(easyGameState.getNumHealthyCrops(), 23);
    }

    /**
     * Uses purchaseChickenCheck() to buy a decorated chicken.
     */
    @Test
    public void purchaseDecoratedChickenTestShouldIncreaseSizeByOne() {
        when(random.nextDouble()).thenReturn(1.0);
        gameLoop.purchaseChickenCheck();
        assertEquals(easyGameState.getAnimals().get("Chicken").size(), 1);
    }

    /**
     * Uses purchaseCowCheck() to buy a decorated cow.
     */
    @Test
    public void purchaseDecoratedCowTestShouldIncreaseSizeByOne() {
        when(random.nextDouble()).thenReturn(1.0);
        gameLoop.purchaseCowCheck();
        assertEquals(easyGameState.getAnimals().get("Cow").size(), 1);
    }

    /**
     * Uses purchaseSheepCheck() to buy a decorated sheep.
     */
    @Test
    public void purchaseDecoratedSheepTestShouldIncreaseSizeByOne() {
        when(random.nextDouble()).thenReturn(1.0);
        gameLoop.purchaseSheepCheck();
        assertEquals(easyGameState.getAnimals().get("Sheep").size(), 1);
    }

    /**
     * Uses purchaseChickenCheck() to buy a chicken.
     */
    @Test
    public void purchaseChickenTestShouldIncreaseSizeByOne() {
        when(random.nextDouble()).thenReturn(0.0);
        gameLoop.purchaseChickenCheck();
        assertEquals(easyGameState.getAnimals().get("Chicken").size(), 1);
    }

    /**
     * Uses purchaseCowCheck() to buy a cow.
     */
    @Test
    public void purchaseCowTestShouldIncreaseSizeByOne() {
        when(random.nextDouble()).thenReturn(0.0);
        gameLoop.purchaseCowCheck();
        assertEquals(easyGameState.getAnimals().get("Cow").size(), 1);
    }

    /**
     * Uses purchaseSheepCheck() to buy a sheep.
     */
    @Test
    public void purchaseSheepTestShouldIncreaseSizeByOne() {
        when(random.nextDouble()).thenReturn(0.0);
        gameLoop.purchaseSheepCheck();
        assertEquals(easyGameState.getAnimals().get("Sheep").size(), 1);
    }

    /**
     * Uses HarvestCrops() to check that they won't harvest due to crop age.
     */
    @Test
    public void harvestCropsShouldReturnCurrentMoney() {
        easyGameState.setCurrentDay(easyGameState.getCurrentDay() + 1);
        gameLoop.harvestCrops();
        assertEquals(easyGameState.getCurrentMoney(), 200, 0.0005);
    }

    /**
     * Uses HavestCrops() to harvest crops on correct day.
     */
    @Test
    public void harvestCropsShouldReturnHarvestedCrops() {
        easyGameState.setCurrentDay(easyGameState.getCurrentDay() + 2);
        when(random.nextDouble()).thenReturn(1.0);
        gameLoop.harvestCrops();
        assertEquals(easyGameState.getCurrentMoney(), 35112.5, 0.0005);
    }

    /**
     * Uses upgradeFarmCheck() to upgrade the farm to tier 2.
     */
    @Test
    public void upgardeFarmTestShouldPurchase() {
        easyGameState.setCurrentMoney(easyGameState.getCurrentMoney() + 2000);
        gameLoop.upgradeFarmCheck();
        assertEquals(easyGameState.getNumFarms(), 2);
    }

    /**
     * Uses winCondtion() to check that the player does not win.
     */
    @Test
    public void winConditionShouldReturnFalse() {
        easyGameState.setCurrentMoney(easyGameState.getCurrentMoney() + 2000);
        assertFalse(gameLoop.winConditoin());
    }

    /**
     * Uses winCondtion() to check that the player win.
     */
    @Test
    public void winConditionShouldReturnTrue() {
        easyGameState.setNumFarms(easyGameState.getNumFarms() + 9);
        gameLoop.upgradeFarmCheck();
        assertTrue(gameLoop.winConditoin());
    }

    /**
     * Uses rainCheck() to check for crop multiplier for rain at night.
     */
    @Test
    public void rainCheckNightShouldReturnDouble() {
        easyGameState.getDayNightCycle();
        easyGameState.setDayNightCycle(DayNightCycle.NIGHT);
        when(random.nextDouble()).thenReturn(1.0);
        gameLoop.rainCheck();
        assertEquals(gameLoop.rainCheck(), 1.2, 0.0005);
    }

    /**
     * Uses rainCheck() to check for crop multiplier with no rain.
     */
    @Test
    public void rainCheckShouldReturnOne() {
        easyGameState.getDayNightCycle();
        easyGameState.setDayNightCycle(DayNightCycle.DAY);
        when(random.nextDouble()).thenReturn(0.0);
        gameLoop.rainCheck();
        assertEquals(gameLoop.rainCheck(), 1.0, 0.0005);
    }

    /**
     * Uses predatorAttackAnimalCheck() to kill a chicken.
     */
    @Test
    public void preadatorAttackAnimalShouldReturnChicken() {
        List<Animal> chickens = easyGameState.getAnimals().get("Chicken");
        Animal chicken1 = (new Chicken(animalAffinity));
        when(random.nextDouble()).thenReturn(2.5);
        ((Chicken) chicken1).setAffinity();
        chickens.add(chicken1);
        Animal chicken2 = (new Chicken(animalAffinity));
        when(random.nextDouble()).thenReturn(2.5);
        ((Chicken) chicken2).setAffinity();
        chickens.add(chicken2);
        Animal chicken3 = (new Chicken(animalAffinity));
        when(random.nextDouble()).thenReturn(2.5);
        ((Chicken) chicken3).setAffinity();
        chickens.add(chicken3);
        when(random.nextDouble()).thenReturn(1.0).thenReturn(0.0).thenReturn(0.0);
        gameLoop.predatorAttackAnimalCheck();
        assertEquals(easyGameState.getAnimals().get("Chicken").size(), 2);
    }

    /**
     * Uses predatorAttackAnimalCheck() to kill a cow.
     */
    @Test
    public void preadatorAttackAnimalShouldReturnCowRecursiveKill() {
        List<Animal> cows = easyGameState.getAnimals().get("Cow");
        Animal cow1 = (new Cow(animalAffinity));
        when(random.nextDouble()).thenReturn(2.5);
        ((Cow) cow1).setAffinity();
        cows.add(cow1);
        Animal cow2 = (new Cow(animalAffinity));
        when(random.nextDouble()).thenReturn(2.5);
        ((Cow) cow2).setAffinity();
        cows.add(cow2);
        Animal cow3 = (new Cow(animalAffinity));
        when(random.nextDouble()).thenReturn(2.5);
        ((Cow) cow3).setAffinity();
        cows.add(cow3);
        when(random.nextDouble()).thenReturn(1.0).thenReturn(0.8).thenReturn(1.0).thenReturn(1.0).thenReturn(0.0);
        gameLoop.predatorAttackAnimalCheck();
        assertEquals(easyGameState.getAnimals().get("Cow").size(), 2);
    }

    /**
     * Uses predatorAttackAnimalCheck() to kill a sheep.
     */
    @Test
    public void preadatorAttackAnimalShouldReturnSheep() {
        List<Animal> sheeps = easyGameState.getAnimals().get("Sheep");
        Animal sheep1 = (new Sheep(animalAffinity));
        when(random.nextDouble()).thenReturn(2.5);
        ((Sheep) sheep1).setAffinity();
        sheeps.add(sheep1);
        Animal sheep2 = (new Sheep(animalAffinity));
        when(random.nextDouble()).thenReturn(2.5);
        ((Sheep) sheep2).setAffinity();
        sheeps.add(sheep2);
        Animal sheep3 = (new Sheep(animalAffinity));
        when(random.nextDouble()).thenReturn(2.5);
        ((Sheep) sheep3).setAffinity();
        sheeps.add(sheep3);
        when(random.nextDouble()).thenReturn(1.0).thenReturn(1.0).thenReturn(0.0);
        gameLoop.predatorAttackAnimalCheck();
        assertEquals(easyGameState.getAnimals().get("Sheep").size(), 2);
    }

    /**
     * Uses cureDiseasedCropCheck() to heal all diseased crops.
     */
    @Test
    public void cureDiseasedCropTestShouldCureAll() {
        easyGameState.setNumDiseasedCrops(25);
        easyGameState.setNumHealthyCrops(0);
        when(random.nextDouble()).thenReturn(1.0);
        gameLoop.cureDiseasedCropCheck();
        assertEquals(easyGameState.getNumHealthyCrops(), 25);
    }

    /**
     * Uses diseasedCropCheck() to wither all healthy crops.
     */
    @Test
    public void diseasedCropTestShouldKillAll() {
        when(random.nextDouble()).thenReturn(1.0);
        gameLoop.diseasedCropCheck();
        assertEquals(easyGameState.getNumDiseasedCrops(), 25);
    }

    /**
     * Uses Day() to run through a full day and at the end buy a farm tier.
     */
    @Test
    public void dayShouldReturnUpgradedFarm() {
        easyGameState.setCurrentMoney(easyGameState.getCurrentMoney() + 200000000);
        gameLoop.day();
        assertEquals(easyGameState.getNumFarms(), 2);
    }

}
