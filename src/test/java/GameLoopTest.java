
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Before;
import org.mockito.Mock;

public class GameLoopTest {

    GameLoop gameLoop;
    GameState easyGameState;
    @Mock
    Random random;

    @Before
    public void setUp() {
        Random random = new Random();
        TasksCurrency incomeCurrency = new TasksCurrency();
        BaseAnimalAffinity animalAffinity = new BaseAnimalAffinity(random);
        Subject diseasedCrop = new Subject();
        Subject sheepSubject = new Subject();
        Subject cowSubject = new Subject();
        Subject chickenSubject = new Subject();
        new DiseasedCropDisplay(diseasedCrop);
        new SheepPurchaseDisplay(sheepSubject);
        new CowPurchaseDisplay(cowSubject);
        new ChickenPurchaseDisplay(chickenSubject);

        GameStateFactory gameStateFactory = new GameStateFactory(random);
        easyGameState = gameStateFactory.getGameState("Easy");
        diseasedCrop.setState(easyGameState);
        sheepSubject.setState(easyGameState);
        cowSubject.setState(easyGameState);
        chickenSubject.setState(easyGameState);

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

    public void predatorAttackCropTestShouldRemoveOneCrop() {
        gameLoop.predatorAttackCropCheck();
        assertEquals(easyGameState.getNumHealthyCrops(), 24);
    }
}
