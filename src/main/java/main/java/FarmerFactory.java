package main.java;

import java.util.Random;

public class FarmerFactory {

    /**
     * Factory for creating our farmer and adjusts with diffictuly.
     * 
     * @param random
     * @param gameMode
     * @return Farmer
     */
    public Farmer createFarmer(String gameMode, Random random) {
        Farmer farmer;
        double baseDecoratedFarmerChance = 0.50;

        if (gameMode.equalsIgnoreCase("Hard")) {
            baseDecoratedFarmerChance = 0.20;
        }

        if (random.nextDouble() > baseDecoratedFarmerChance) {
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
