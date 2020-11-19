package main.java;

public class Main {
    public static void main(String[] args) {

        Farmer farmer1 = new BaseFarmers("John");
        Farmer farmer2 = (new CropAffinityFarmerDecorator(new BaseFarmers("Jason")));
        double cropAffinity = farmer1.cropAffinity();
        double husbandryAffinity = farmer1.husbandryAffinity();
        double profitAffinity = farmer1.profitAffinity();

        double cropAffinity2 = farmer2.cropAffinity();
        double husbandryAffinity2 = farmer2.husbandryAffinity();
        double profitAffinity2 = farmer2.profitAffinity();

        System.out.println(farmer1.getName() + "'s stats are \nCrop Affinity : " + cropAffinity
                + " \nHusbrandry Affinity :" + husbandryAffinity + " \nProfitAffinity : " + profitAffinity + "\n");

        System.out.println(farmer2.getName() + "'s stats are \nCrop Affinity : " + cropAffinity2
                + " \nHusbrandry Affinity :" + husbandryAffinity2 + " \nProfitAffinity : " + profitAffinity2 + "\n");

    }

}