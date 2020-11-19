package main.java;

public class BaseFarmers extends Farmer {

    public BaseFarmers(String farmerName) {
        this.farmerName = farmerName;
        this.cropAffinity = getCropAffinity();
        this.husbandryAffinity = getHusbandryAffinity();
        this.profitAffinity = getProfitAffinity();

    }
}
