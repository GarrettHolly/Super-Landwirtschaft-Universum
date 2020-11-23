import java.util.Random;

public class FarmerFactory {

    /**
     * Factory for creating our farmer and adjusts with diffictuly.
     * 
     * @param random   represents a random number
     * @param gameMode represents the current gameMode
     * @return farmer returns a farmer
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
                String cropsAffinity = "'s stats are \nCrop Affinity : " + farmer.getCropAffinity();
                String husbandryAffinity = " \nHusbrandry Affinity :" + farmer.getHusbandryAffinity();
                String profitAffinity = " \nProfitAffinity : " + farmer.getProfitAffinity();
                System.out.println(farmer.getName() + cropsAffinity + husbandryAffinity + profitAffinity + "\n");

            } else if (random.nextDouble() > 0.50) {
                farmer = (new CropAffinityFarmerDecorator(new BaseFarmers("Crop Affinity John", random)));
                String cropsAffinity = "'s stats are \nCrop Affinity : " + farmer.getCropAffinity();
                String husbandryAffinity = " \nHusbrandry Affinity :" + farmer.getHusbandryAffinity();
                String profitAffinity = " \nProfitAffinity : " + farmer.getProfitAffinity();
                System.out.println(farmer.getName() + cropsAffinity + husbandryAffinity + profitAffinity + "\n");
            } else if (random.nextDouble() < 0.50) {
                farmer = (new HusbandryAffinityFarmerDecorator(new BaseFarmers("Husbandry Affinity John", random)));
                String cropsAffinity = "'s stats are \nCrop Affinity : " + farmer.getCropAffinity();
                String husbandryAffinity = " \nHusbrandry Affinity :" + farmer.getHusbandryAffinity();
                String profitAffinity = " \nProfitAffinity : " + farmer.getProfitAffinity();
                System.out.println(farmer.getName() + cropsAffinity + husbandryAffinity + profitAffinity + "\n");
            } else {
                farmer = new BaseFarmers("Base Stats John", random);
                String cropsAffinity = "'s stats are \nCrop Affinity : " + farmer.getCropAffinity();
                String husbandryAffinity = " \nHusbrandry Affinity :" + farmer.getHusbandryAffinity();
                String profitAffinity = " \nProfitAffinity : " + farmer.getProfitAffinity();
                System.out.println(farmer.getName() + cropsAffinity + husbandryAffinity + profitAffinity + "\n");
            }

        } else {
            farmer = new BaseFarmers("Base Stats John", random);
            String cropsAffinity = "'s stats are \nCrop Affinity : " + farmer.getCropAffinity();
            String husbandryAffinity = " \nHusbrandry Affinity :" + farmer.getHusbandryAffinity();
            String profitAffinity = " \nProfitAffinity : " + farmer.getProfitAffinity();
            System.out.println(farmer.getName() + cropsAffinity + husbandryAffinity + profitAffinity + "\n");
        }
        return farmer;
    }

}
