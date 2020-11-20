package main.java;

public class GameLoop {
    // private final double animalPredatorChance = 0.1;
    // private final double cropWitherChance = 0.4;
    // private final double cropPredatorChance = 0.1;
    // private final double farmerTreatCropChance = 0.7;
    // private double animalAge = 1;
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

    }

    private void cureDiseasedCropCheck() {

    }

    private void predatorAttackAnimalCheck() {

    }

    private void predatorAttackCropCheck() {

    }

}
