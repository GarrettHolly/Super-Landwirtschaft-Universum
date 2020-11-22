package main.java;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        GameState gameState = new GameState();
        GameLoop gameLoop = new GameLoop(gameState);

        gameState.setAnimals(new HashMap<>());
        gameState.getAnimals().put("Chicken", new ArrayList<>());
        gameState.getAnimals().put("Cow", new ArrayList<>());
        gameState.getAnimals().put("Sheep", new ArrayList<>());

        gameLoop.loop();
    }

}