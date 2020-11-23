import java.util.Random;

/**
 * Gives the base affinities for animals
 */
public class BaseAnimalAffinity {
    Random random;

    /**
     * 
     * @param random
     */
    public BaseAnimalAffinity(Random random) {
        this.random = random;
    }

    /**
     * @return double
     */
    public double getAffinity() {
        double affinityBase = Math.round(random.nextDouble()) + 2 * .25;
        return affinityBase;
    }
}
