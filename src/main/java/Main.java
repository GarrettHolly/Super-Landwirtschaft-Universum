import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
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
        GameState easyGameState = gameStateFactory.getGameState("Easy");
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

        GameLoop gameLoop = new GameLoop(easyGameState, random, incomeCurrency, animalAffinity, subjects);

        gameLoop.loop();
    }

}