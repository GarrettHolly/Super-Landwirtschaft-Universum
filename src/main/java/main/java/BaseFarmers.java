package main.java;

import java.util.Random;

public class BaseFarmers extends Farmer {

    /**
     * Constructor for base farmer stats
     * 
     * @param farmerName
     * @param random
     */
    public BaseFarmers(String farmerName, Random random) {
        this.farmerName = farmerName;
        this.random = random;
        this.cropAffinity = getCropAffinity();
        this.husbandryAffinity = getHusbandryAffinity();
        this.profitAffinity = getProfitAffinity();

    }
}
