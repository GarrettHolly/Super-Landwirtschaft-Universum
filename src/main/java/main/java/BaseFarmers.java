package main.java;

public class BaseFarmers extends Farmer {

    public BaseFarmers(String farmerName) {
        this.cropAffinity = cropAffinity();
        this.husbandryAffinity = husbandryAffinity();
        this.profitAffinity = profitAffinity();

    }
}
