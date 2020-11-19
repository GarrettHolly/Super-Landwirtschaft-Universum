package main.java;

public class BaseFarmers extends Farmer {

    public BaseFarmers(String farmerName) {
        this.farmerName = farmerName;
        this.cropAffinity = cropAffinity();
        this.husbandryAffinity = husbandryAffinity();
        this.profitAffinity = profitAffinity();

    }
}
