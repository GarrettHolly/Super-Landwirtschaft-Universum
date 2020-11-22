package main.java;

import java.util.Random;

public class BaseFarmers extends Farmer {

    public BaseFarmers(String farmerName, Random random) {
        this.farmerName = farmerName;
        this.random = random;
        this.cropAffinity = getCropAffinity();
        this.husbandryAffinity = getHusbandryAffinity();
        this.profitAffinity = getProfitAffinity();

    }
}
