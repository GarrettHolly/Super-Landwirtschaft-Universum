package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Random random = new Random();
        TasksCurrency incomeCurrency = new TasksCurrency();
        BaseAnimalAffinity animalAffinity = new BaseAnimalAffinity(random);

        GameState gameState = new GameState();
        GameLoop gameLoop = new GameLoop(gameState, random, incomeCurrency, animalAffinity);

        gameState.setNumFarms(1);
        gameState.setNumHealthyCrops(25);
        gameState.setNumDiseasedCrops(0);
        gameState.setCurrentMoney(200);
        gameState.setFarmer(createFarmer(random));
        PurchaseCost purchaseCost = new PurchaseCost();
        purchaseCost.setChickenCost(10);
        purchaseCost.setCowCost(25);
        purchaseCost.setSheepCost(35);
        purchaseCost.setUpgradeFarmCost(1000);
        gameState.setPurchaseCost(purchaseCost);
        gameState.setCurrentDay(1);
        gameState.setDayNightCycle(DayNightCycle.DAY);
        gameState.setAnimals(new HashMap<>());
        gameState.getAnimals().put("Chicken", new ArrayList<>());
        gameState.getAnimals().put("Cow", new ArrayList<>());
        gameState.getAnimals().put("Sheep", new ArrayList<>());

        gameLoop.loop();
    }

    /**
     * @param random
     * @return Farmer
     */
    private static Farmer createFarmer(Random random) {
        Farmer farmer;

        if (random.nextDouble() > 0.50) {
            if (random.nextDouble() > 0.80) {
                farmer = (new ProfitAffinityFarmerDecorator(new BaseFarmers("Profit Affinity John", random)));
                System.out.println(farmer.getName() + "'s stats are \nCrop Affinity : " + farmer.getCropAffinity()
                        + " \nHusbrandry Affinity :" + farmer.getHusbandryAffinity() + " \nProfitAffinity : "
                        + farmer.getProfitAffinity() + "\n");

            } else if (random.nextDouble() > 0.50) {
                farmer = (new CropAffinityFarmerDecorator(new BaseFarmers("Crop Affinity John", random)));
                System.out.println(farmer.getName() + "'s stats are \nCrop Affinity : " + farmer.getCropAffinity()
                        + " \nHusbrandry Affinity :" + farmer.getHusbandryAffinity() + " \nProfitAffinity : "
                        + farmer.getProfitAffinity() + "\n");
            } else if (random.nextDouble() < 0.50) {
                farmer = (new HusbandryAffinityFarmerDecorator(new BaseFarmers("Husbandry Affinity John", random)));
                System.out.println(farmer.getName() + "'s stats are \nCrop Affinity : " + farmer.getCropAffinity()
                        + " \nHusbrandry Affinity :" + farmer.getHusbandryAffinity() + " \nProfitAffinity : "
                        + farmer.getProfitAffinity() + "\n");
            } else {
                farmer = new BaseFarmers("Base Stats John", random);
                System.out.println(farmer.getName() + "'s stats are \nCrop Affinity : " + farmer.getCropAffinity()
                        + " \nHusbrandry Affinity :" + farmer.getHusbandryAffinity() + " \nProfitAffinity : "
                        + farmer.getProfitAffinity() + "\n");
            }

        } else {
            farmer = new BaseFarmers("Base Stats John", random);
            System.out.println(farmer.getName() + "'s stats are \nCrop Affinity : " + farmer.getCropAffinity()
                    + " \nHusbrandry Affinity :" + farmer.getHusbandryAffinity() + " \nProfitAffinity : "
                    + farmer.getProfitAffinity() + "\n");
        }
        return farmer;
    }

}