package main.java;

public class Main {
    public static void main(String[] args) {

        Farmer farmer1 = new BaseFarmers("John");
        double cropAffinity = farmer1.cropAffinity();
        double husbandryAffinity = farmer1.husbandryAffinity();
        double profitAffinity = farmer1.profitAffinity();

        System.out.println(farmer1.getName() + "'s stats are \nCrop Affinity : " + cropAffinity
                + " \nHusbrandry Affinity :" + husbandryAffinity + " \nProfitAffinity : " + profitAffinity);

    }

}