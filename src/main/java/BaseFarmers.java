import java.util.Random;

public class BaseFarmers extends Farmer {

    /**
     * Constructor for base farmer stats.
     * 
     * @param farmerName represents the string farmer name
     * @param random     represents a random value
     */
    public BaseFarmers(String farmerName, Random random) {
        this.farmerName = farmerName;
        this.random = random;
        this.cropAffinity = getCropAffinity();
        this.husbandryAffinity = getHusbandryAffinity();
        this.profitAffinity = getProfitAffinity();

    }
}
