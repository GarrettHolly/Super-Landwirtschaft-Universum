package main.java;

import java.util.List;
import java.util.Random;

public class GameLoop {
    // animalPredatorChance = 0.1;
    // cropWitherChance = 0.4;
    // cropPredatorChance = 0.1;
    // farmerTreatCropChance = 0.7;
    // animalAge = 1;
    Random random = new Random();
    GameState gameState;
    AnimalAffinity animalAffinity;
    TasksCurrency incomeCurrency;

    public GameLoop(GameState gameState, TasksCurrency incomCurrency) {
        this.gameState = gameState;
        this.incomeCurrency = incomCurrency;
        this.animalAffinity = new AnimalAffinity();
    }

    public void loop() {
        day();
        night();
    }

    private void day() {
        diseasedCropCheck();
        cureDiseasedCropCheck();
        predatorAttackCropCheck();
        calculateChickenIncome();
        calculateCowIncome();
        calculateSheepIncome();
        calculateCropIncome();
        purchaseChickenCheck();
        purchaseCowCheck();
        purchaseSheepCheck();
        displayMoney();
    }

    private void night() {
        predatorAttackAnimalCheck();
        displayMoney();
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
                int randomElement = (gameState.getAnimals().get("Sheep").size());
                gameState.getAnimals().get("Sheep").remove(randomElement);
                System.out.println("A Sheep was killed during the night, you now have "
                        + gameState.getAnimals().get("Sheep").size() + " sheep left.");
            } else if (random.nextDouble() > 0.75) {
                int randomElement = (gameState.getAnimals().size());
                gameState.getAnimals().get("Cow").remove(randomElement);
                System.out.println("A Cow was killed during the night, you now have "
                        + gameState.getAnimals().get("Cow").size() + " cows left.");
            } else {
                int randomElement = (gameState.getAnimals().size());
                gameState.getAnimals().get("Chicken").remove(randomElement);
                System.out.println("A Chicken was killed during the night, you now have "
                        + gameState.getAnimals().get("Chicken").size() + " chickens left.");
            }
        }
        if (random.nextDouble() > 0.60) {
            predatorAttackAnimalCheck();
        }
    }

    private void predatorAttackCropCheck() {
        if (random.nextDouble() > 0.90) {
            gameState.setNumHealthyCrops(gameState.getNumHealthyCrops() - 1);
            gameState.setNumDiseasedCrops(gameState.getNumHealthyCrops() - 1);
            System.out.println(
                    "A bunny has killed one of your crops you now have " + gameState.getNumHealthyCrops() + " left.");
            if (random.nextDouble() > 0.50) {
                predatorAttackCropCheck();
            }
        }
    }

    private void purchaseChickenCheck() {
        int chickenCost = 10;
        if (gameState.getCurrentMoney() > chickenCost + 25) {
            if (random.nextDouble() > 0.50) {
                Animal chicken = (new ChickenAffinityDecorator(new Chicken(animalAffinity)));
                List<Animal> chickens = gameState.getAnimals().get("Chicken");
                chickens.add(chicken);
            } else {
                Animal chicken = (new Chicken(animalAffinity));
                List<Animal> chickens = gameState.getAnimals().get("Chicken");
                chickens.add(chicken);
            }
        }
    }

    private void purchaseCowCheck() {
        int cowCost = 25;
        if (gameState.getCurrentMoney() > cowCost + 55) {
            if (random.nextDouble() > 0.50) {
                Animal cow = (new CowAffinityDecorator(new Cow(animalAffinity)));
                List<Animal> cows = gameState.getAnimals().get("Cow");
                cows.add(cow);
            } else {
                Animal cow = (new Cow(animalAffinity));
                List<Animal> cows = gameState.getAnimals().get("Cow");
                cows.add(cow);
            }
        }
    }

    private void purchaseSheepCheck() {
        int sheepCost = 35;
        if (gameState.getCurrentMoney() > sheepCost + 75) {
            if (random.nextDouble() > 0.50) {
                Animal sheep = (new SheepAffinityDecorator(new Sheep(animalAffinity)));
                List<Animal> sheeps = gameState.getAnimals().get("Sheep");
                sheeps.add(sheep);
            } else {
                Animal sheep = (new Sheep(animalAffinity));
                List<Animal> sheeps = gameState.getAnimals().get("Sheep");
                sheeps.add(sheep);
            }
        }
    }

    private void calculateChickenIncome() {
        double chickenIncome = incomeCurrency.getCowIncome();
        double total = 0;
        for (Animal animal : gameState.getAnimals().get("Cow")) {
            Chicken chicken = (Chicken) animal;
            total += chickenIncome * chicken.getChickenAffinity() * gameState.getFarmer().getHusbandryAffinity()
                    * gameState.getFarmer().getProfitAffinity();
        }
        gameState.setCurrentMoney(gameState.getCurrentMoney() + total);
    }

    private void calculateCowIncome() {
        double cowIncome = incomeCurrency.getCowIncome();
        double total = 0;
        for (Animal animal : gameState.getAnimals().get("Cow")) {
            Cow cow = (Cow) animal;
            total += cowIncome * cow.getCowAffinity() * gameState.getFarmer().getHusbandryAffinity()
                    * gameState.getFarmer().getProfitAffinity();
        }
        gameState.setCurrentMoney(gameState.getCurrentMoney() + total);

    }

    private void calculateSheepIncome() {
        double sheepIncome = incomeCurrency.getCowIncome();
        double total = 0;
        for (Animal animal : gameState.getAnimals().get("Sheep")) {
            Sheep sheep = (Sheep) animal;
            total += sheepIncome * sheep.getSheepAffinity() * gameState.getFarmer().getHusbandryAffinity()
                    * gameState.getFarmer().getProfitAffinity();
        }
        gameState.setCurrentMoney(gameState.getCurrentMoney() + total);
    }

    private void calculateCropIncome() {
        double cropIncome = incomeCurrency.getCropIncome();
        double total = 0;
        for (int i = 0; i < gameState.getNumHealthyCrops(); i++) {
            cropIncome += cropIncome * gameState.getFarmer().getCropAffinity()
                    * gameState.getFarmer().getProfitAffinity();
        }
        gameState.setCurrentMoney(gameState.getCurrentMoney() + (total * rainCheck()));
    }

    private void farmTeir() {

    }

    private void displayMoney() {
        System.out.println(Math.round(gameState.getCurrentMoney()));
    }

    private double rainCheck() {
        switch (gameState.getDayNightCycle()) {
            case DAY:
                if (random.nextDouble() > 0.90) {
                    System.out.println("It rained today you recieved a bonus on harvested crops!");
                    return 1.2;
                }
                break;

            case NIGHT:
                if (random.nextDouble() > 0.60) {
                    System.out.println("It rained tonight you recieved a bonus on harvested crops!");
                    return 1.2;
                }
                break;
        }
        return 1;
    }
}
