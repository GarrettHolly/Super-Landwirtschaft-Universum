package main.java;

import java.util.Random;

public class GameLoop {
    // private final double animalPredatorChance = 0.1;
    // private final double cropWitherChance = 0.4;
    // private final double cropPredatorChance = 0.1;
    // private final double farmerTreatCropChance = 0.7;
    // private double animalAge = 1;
    Random random = new Random();
    GameState gameState;

    public GameLoop(GameState gameState) {
        this.gameState = gameState;
    }

    public void loop() {
        day();
        night();
    }

    private void day() {
        diseasedCropCheck();
        cureDiseasedCropCheck();
        predatorAttackCropCheck();
    }

    private void night() {
        predatorAttackAnimalCheck();
    }

    private void diseasedCropCheck() {
        for (int i = 0; i < gameState.getNumDiseasedCrops(); i++) {
            if ((random.nextDouble() > 0.70)) {
                gameState.setNumHealthyCrops(gameState.getNumHealthyCrops() - 1);
                gameState.setNumDiseasedCrops(gameState.getNumDiseasedCrops() + 1);
            }
        }
    }

    private void cureDiseasedCropCheck() {
        for (int i = 0; i < gameState.getNumHealthyCrops(); i++) {
            if ((random.nextDouble() > 0.30)) {
                gameState.setNumHealthyCrops(gameState.getNumDiseasedCrops() + 1);
                gameState.setNumDiseasedCrops(gameState.getNumHealthyCrops() - 1);
            }
        }
    }

    private void predatorAttackAnimalCheck() {

    }

    private void predatorAttackCropCheck() {

    }

    // TODO: decorated chicken purhcased chance fill out;

    private void chickenPurchased() {

    }

    private void cowPurchased() {

    }

    private void sheepPurchased() {

    }

}
