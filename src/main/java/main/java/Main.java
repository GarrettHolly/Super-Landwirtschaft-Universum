package main.java;

import java.util.Random;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Random random = new Random();

        // Farmer farmer1 = new BaseFarmers("John");
        // Farmer farmer2 = (new CropAffinityFarmerDecorator(new BaseFarmers("Jason")));
        // double cropAffinity = farmer1.getCropAffinity();
        // double husbandryAffinity = farmer1.getHusbandryAffinity();
        // double profitAffinity = farmer1.getProfitAffinity();

        // double cropAffinity2 = farmer2.getCropAffinity();
        // double husbandryAffinity2 = farmer2.getHusbandryAffinity();
        // double profitAffinity2 = farmer2.getProfitAffinity();

        // System.out.println(farmer1.getName() + "'s stats are \nCrop Affinity : " +
        // cropAffinity
        // + " \nHusbrandry Affinity :" + husbandryAffinity + " \nProfitAffinity : " +
        // profitAffinity + "\n");

        // System.out.println(farmer2.getName() + "'s stats are \nCrop Affinity : " +
        // cropAffinity2
        // + " \nHusbrandry Affinity :" + husbandryAffinity2 + " \nProfitAffinity : " +
        // profitAffinity2 + "\n");

        // Farmer farmer = new BaseFarmers("");
        // Farmer stats = farmer;

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

}