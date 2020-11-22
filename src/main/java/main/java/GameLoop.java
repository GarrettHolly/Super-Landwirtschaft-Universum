package main.java;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GameLoop {

    Random random;
    GameState gameState;
    BaseAnimalAffinity animalAffinity;
    TasksCurrency incomeCurrency;
    DecimalFormat df = new DecimalFormat("#,###.00");

    public GameLoop(GameState gameState, Random random, TasksCurrency incomeCurrency,
            BaseAnimalAffinity animalAffinity) {
        this.gameState = gameState;
        this.random = random;
        this.incomeCurrency = incomeCurrency;
        this.animalAffinity = animalAffinity;
    }

    public void loop() {
        while (true) {
            System.out.println("Today is day " + gameState.getCurrentDay() + "\n");
            day();
            if (winConditoin()) {
                System.out.println("The Farm has reached max tier you win!");
                return;
            }
            night();
            gameState.setCurrentDay(gameState.getCurrentDay() + 1);
            try {
                for (int i = 0; i < 5; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print((5 - i) + "... ");
                }
                System.out.println();

            } catch (Exception e) {
                System.out.println("Something went wrong with sleep but it shouldn't have good luck");
            }

        }
    }

    private void day() {
        diseasedCropCheck();
        cureDiseasedCropCheck();
        predatorAttackCropCheck();
        animalChecks(gameState.getAnimals().get("Chicken"), incomeCurrency.getChickenIncome());
        animalChecks(gameState.getAnimals().get("Cow"), incomeCurrency.getCowIncome());
        animalChecks(gameState.getAnimals().get("Sheep"), incomeCurrency.getSheepIncome());
        harvestCrops();
        purchaseChickenCheck();
        purchaseCowCheck();
        purchaseSheepCheck();
        upgradeFarmCheck();
        displayMoney();

    }

    private void night() {
        predatorAttackAnimalCheck();
    }

    private void animalChecks(List<Animal> animals, double income) {
        List<Animal> animalsToKill = new ArrayList<>();

        for (Animal animal : animals) {
            if (animal.getAge() < 3) {
                animal.setAge(animal.getAge() + 1);
                continue;
            }
            deathCheck(animal, animalsToKill);
            harvestAnimal(animal, income);
            animal.setAge(animal.getAge() + 1);
        }
        animals.removeAll(animalsToKill);
    }

    private void deathCheck(Animal animal, List<Animal> animalsToKill) {
        if (animal.getAge() >= 14) {
            animalsToKill.add(animal);
        }
    }

    private void harvestAnimal(Animal animal, double income) {
        if (animal.getAge() % 2 == 0) {
            return;
        }
        double total = 0;
        total += income * animal.getAffinity() * gameState.getFarmer().getHusbandryAffinity()
                * gameState.getFarmer().getProfitAffinity();
        gameState.setCurrentMoney(gameState.getCurrentMoney() + total);
        System.out.println("You made $" + df.format(total) + " from " + animal.toString() + ".");

    }

    private void diseasedCropCheck() {
        for (int i = 0; i < gameState.getNumHealthyCrops(); i++) {
            if ((random.nextDouble() > 0.70)) {
                gameState.setNumHealthyCrops(gameState.getNumHealthyCrops() - 1);
                gameState.setNumDiseasedCrops(gameState.getNumDiseasedCrops() + 1);
                System.out.println("A crop has withered you have a chance to cure it still. You have "
                        + gameState.getNumHealthyCrops() + " crops still alive.");
            }
        }
    }

    private void cureDiseasedCropCheck() {
        for (int i = 0; i < gameState.getNumDiseasedCrops(); i++) {
            if ((random.nextDouble() > 0.30)) {
                gameState.setNumHealthyCrops(gameState.getNumHealthyCrops() + 1);
                gameState.setNumDiseasedCrops(gameState.getNumDiseasedCrops() - 1);
                System.out.println("A crop has been cured you have " + gameState.getNumHealthyCrops() + " alive.");
            }
        }
    }

    private void predatorAttackAnimalCheck() {
        if (random.nextDouble() > 0.90) {
            int sheepSize = gameState.getAnimals().get("Sheep").size();
            int chickenSize = gameState.getAnimals().get("Chicken").size();
            int cowSize = gameState.getAnimals().get("Cow").size();
            if (random.nextDouble() > 0.90 && sheepSize > 0) {
                int randomElement = sheepSize - 1;
                gameState.getAnimals().get("Sheep").remove(randomElement);
                System.out.println("A Sheep was killed during the night, you now have "
                        + gameState.getAnimals().get("Sheep").size() + " sheep left.");
            } else if (random.nextDouble() > 0.75 && cowSize > 0) {
                int randomElement = cowSize - 1;
                gameState.getAnimals().get("Cow").remove(randomElement);
                System.out.println("A Cow was killed during the night, you now have "
                        + gameState.getAnimals().get("Cow").size() + " cows left.");
            } else if (chickenSize > 0) {
                int randomElement = chickenSize - 1;
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
            System.out.println(
                    "A bunny has killed one of your crops you now have " + gameState.getNumHealthyCrops() + " left.");
            if (random.nextDouble() > 0.50) {
                predatorAttackCropCheck();
            }
        }
    }

    private void purchaseChickenCheck() {
        int chickenCost = gameState.getPurchaseCost().getChickenCost();

        if (gameState.getAnimals().get("Chicken").size() >= gameState.getNumFarms() * 15) {
            return;
        }

        if (gameState.getCurrentMoney() > chickenCost + 25) {
            List<Animal> chickens = gameState.getAnimals().get("Chicken");
            if (random.nextDouble() > 0.50) {
                Animal chicken = (new ChickenAffinityDecorator(new Chicken(animalAffinity)));
                ((ChickenAffinityDecorator) chicken).setAffinity();
                chickens.add(chicken);

            } else {
                Animal chicken = (new Chicken(animalAffinity));
                ((Chicken) chicken).setAffinity();
                chickens.add(chicken);
            }

            System.out.println("You have purchased a chicken.");
            gameState.setCurrentMoney(gameState.getCurrentMoney() - gameState.getPurchaseCost().getChickenCost());
            gameState.getPurchaseCost().setCowCost(chickenCost + 5);
        }
    }

    private void purchaseCowCheck() {
        int cowCost = gameState.getPurchaseCost().getCowCost();
        if (gameState.getNumFarms() * 15 >= gameState.getAnimals().get("Cow").size()) {
            return;
        }

        if (gameState.getCurrentMoney() > cowCost + 55) {
            List<Animal> cows = gameState.getAnimals().get("Cow");
            if (random.nextDouble() > 0.50) {
                Animal cow = (new CowAffinityDecorator(new Cow(animalAffinity)));
                ((CowAffinityDecorator) cow).setAffinity();
                cows.add(cow);

            } else {
                Animal cow = (new Cow(animalAffinity));
                ((Cow) cow).setAffinity();
                cows.add(cow);
            }

            System.out.println("You have purchased a cow.");
            gameState.setCurrentMoney(gameState.getCurrentMoney() - gameState.getPurchaseCost().getCowCost());
            gameState.getPurchaseCost().setCowCost(cowCost + 10);

        }
    }

    private void purchaseSheepCheck() {
        int sheepCost = gameState.getPurchaseCost().getSheepCost();

        if (gameState.getAnimals().get("Sheep").size() >= gameState.getNumFarms() * 15) {
            return;
        }

        if (gameState.getCurrentMoney() > sheepCost + 75) {
            List<Animal> sheeps = gameState.getAnimals().get("Sheep");
            if (random.nextDouble() > 0.50) {
                Animal sheep = (new SheepAffinityDecorator(new Sheep(animalAffinity)));
                ((SheepAffinityDecorator) sheep).setAffinity();
                sheeps.add(sheep);

            } else {
                Animal sheep = (new Sheep(animalAffinity));
                ((Sheep) sheep).setAffinity();
                sheeps.add(sheep);
            }

            System.out.println("You have purchased a sheep.");
            gameState.setCurrentMoney(gameState.getCurrentMoney() - gameState.getPurchaseCost().getSheepCost());
            gameState.getPurchaseCost().setSheepCost(sheepCost + 15);
        }
    }

    private void harvestCrops() {
        if (gameState.getCurrentDay() % 3 != 0) {
            return;
        }

        double cropIncome = incomeCurrency.getCropIncome();
        double total = cropIncome * gameState.getFarmer().getCropAffinity() * gameState.getFarmer().getProfitAffinity()
                * gameState.getNumHealthyCrops();

        double rainCheckTotal = (total * rainCheck());
        gameState.setCurrentMoney(gameState.getCurrentMoney() + rainCheckTotal);
        System.out.println(
                "You made " + df.format(rainCheckTotal) + " money from " + gameState.getNumHealthyCrops() + " crops.");
    }

    private double rainCheck() {
        switch (gameState.getDayNightCycle()) {
            case DAY:
                if (random.nextDouble() > 0.00) {
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

    private void upgradeFarmCheck() {
        int farmUpgradeCost = gameState.getPurchaseCost().getUpgradeFarmCost();
        if (gameState.getCurrentMoney() > farmUpgradeCost + 200) {
            gameState.setNumFarms(gameState.getNumFarms() + 1);
            gameState.setNumHealthyCrops(gameState.getNumHealthyCrops() + 25);
            gameState.setCurrentMoney(gameState.getCurrentMoney() - gameState.getPurchaseCost().getUpgradeFarmCost());
            gameState.getPurchaseCost().setUpgradeFarmCost(farmUpgradeCost * 2);
            System.out.println("Your farm has been upgraded and your current tier is " + gameState.getNumFarms());
        }
    }

    private boolean winConditoin() {
        if (gameState.getNumFarms() >= 10) {
            return true;
        }
        return false;
    }

    private void displayMoney() {
        System.out.println("You have $" + df.format(Math.round(gameState.getCurrentMoney())) + "\n");
    }

}
