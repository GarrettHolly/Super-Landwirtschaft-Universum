package main.java;

import java.util.Random;

public class GameLoop {
    // animalPredatorChance = 0.1;
    // cropWitherChance = 0.4;
    // cropPredatorChance = 0.1;
    // farmerTreatCropChance = 0.7;
    // animalAge = 1;
    Random random = new Random();
    GameState gameState;
    TasksCurrency incomeCurrency;

    public GameLoop(GameState gameState, TasksCurrency incomCurrency) {
        this.gameState = gameState;
        this.incomeCurrency = incomCurrency;
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

    private void createFarmer() {

        if (random.nextDouble() > 0.50) {
            if (random.nextDouble() > 0.80) {
                Farmer farmer = (new ProfitAffinityFarmerDecorator(new BaseFarmers("Profit Affinity John")));
                System.out.println(farmer.getName() + "'s stats are \nCrop Affinity : " + farmer.getCropAffinity()
                        + " \nHusbrandry Affinity :" + farmer.getHusbandryAffinity() + " \nProfitAffinity : "
                        + farmer.getProfitAffinity() + "\n");
            } else if (random.nextDouble() > 0.50) {
                Farmer farmer = (new CropAffinityFarmerDecorator(new BaseFarmers("Crop Affinity John")));
                System.out.println(farmer.getName() + "'s stats are \nCrop Affinity : " + farmer.getCropAffinity()
                        + " \nHusbrandry Affinity :" + farmer.getHusbandryAffinity() + " \nProfitAffinity : "
                        + farmer.getProfitAffinity() + "\n");
            } else if (random.nextDouble() < 0.50) {
                Farmer farmer = (new HusbandryAffinityFarmerDecorator(new BaseFarmers("Husbandry Affinity John")));
                System.out.println(farmer.getName() + "'s stats are \nCrop Affinity : " + farmer.getCropAffinity()
                        + " \nHusbrandry Affinity :" + farmer.getHusbandryAffinity() + " \nProfitAffinity : "
                        + farmer.getProfitAffinity() + "\n");
            } else {
                Farmer farmer = new BaseFarmers("Base Stats John");
                System.out.println(farmer.getName() + "'s stats are \nCrop Affinity : " + farmer.getCropAffinity()
                        + " \nHusbrandry Affinity :" + farmer.getHusbandryAffinity() + " \nProfitAffinity : "
                        + farmer.getProfitAffinity() + "\n");
            }

        } else {
            Farmer farmer = new BaseFarmers("Base Stats John");
            System.out.println(farmer.getName() + "'s stats are \nCrop Affinity : " + farmer.getCropAffinity()
                    + " \nHusbrandry Affinity :" + farmer.getHusbandryAffinity() + " \nProfitAffinity : "
                    + farmer.getProfitAffinity() + "\n");
        }
    }

    private void diseasedCropCheck() {
        for (int i = 0; i < gameState.getNumDiseasedCrops(); i++) {
            if ((random.nextDouble() > 0.70)) {
                gameState.setNumHealthyCrops(gameState.getNumHealthyCrops() - 1);
                gameState.setNumDiseasedCrops(gameState.getNumDiseasedCrops() + 1);
                System.out.println("A crop has withered you have a chance to cure it still. You have "
                        + gameState.getNumHealthyCrops() + " still alive.");
            }
        }
    }

    private void cureDiseasedCropCheck() {
        for (int i = 0; i < gameState.getNumHealthyCrops(); i++) {
            if ((random.nextDouble() > 0.30)) {
                gameState.setNumHealthyCrops(gameState.getNumDiseasedCrops() + 1);
                gameState.setNumDiseasedCrops(gameState.getNumHealthyCrops() - 1);
                System.out.println("A crop has been cured you have " + gameState.getNumHealthyCrops() + " alive.");
            }
        }
    }

    private void predatorAttackAnimalCheck() {
        if (random.nextDouble() > 0.90) {
            if (random.nextDouble() > 0.90) {
                gameState.getAnimals().get("Sheep");
                int randomElement = (gameState.getAnimals().get("Sheep").size());
                gameState.getAnimals().get("Sheep").remove(randomElement);
            } else if (random.nextDouble() > 0.75) {
                gameState.getAnimals().get("Cow");
                int randomElement = (gameState.getAnimals().size());
                gameState.getAnimals().get("Cow").remove(randomElement);
            } else {
                gameState.getAnimals().get("Chicken");
                int randomElement = (gameState.getAnimals().size());
                gameState.getAnimals().get("Chicken").remove(randomElement);
            }
        }
    }

    private void predatorAttackCropCheck() {
        if (random.nextDouble() > 0.90) {

        }
    }

    private void chickenPurchased() {

    }

    private void cowPurchased() {

    }

    private void sheepPurchased() {

    }

    private void chickenIncome() {

    }

    private void cowIncome() {
        double cowIncome = incomeCurrency.getCowIncome();
        // cowIncome = cowIncome * gameState.getAnimals().get("Cow");

    }

    private void SheepIncome() {

    }

    private void CropIncome() {

    }
}
