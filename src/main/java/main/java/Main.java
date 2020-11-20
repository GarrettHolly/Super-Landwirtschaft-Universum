package main.java;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Farmer farmer1 = new BaseFarmers("John");
        Farmer farmer2 = (new CropAffinityFarmerDecorator(new BaseFarmers("Jason")));
        double cropAffinity = farmer1.getCropAffinity();
        double husbandryAffinity = farmer1.getHusbandryAffinity();
        double profitAffinity = farmer1.getProfitAffinity();

        double cropAffinity2 = farmer2.getCropAffinity();
        double husbandryAffinity2 = farmer2.getHusbandryAffinity();
        double profitAffinity2 = farmer2.getProfitAffinity();

        System.out.println(farmer1.getName() + "'s stats are \nCrop Affinity : " + cropAffinity
                + " \nHusbrandry Affinity :" + husbandryAffinity + " \nProfitAffinity : " + profitAffinity + "\n");

        System.out.println(farmer2.getName() + "'s stats are \nCrop Affinity : " + cropAffinity2
                + " \nHusbrandry Affinity :" + husbandryAffinity2 + " \nProfitAffinity : " + profitAffinity2 + "\n");

    }

}