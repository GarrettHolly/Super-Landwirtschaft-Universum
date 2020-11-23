import java.util.Random;

/**
 * Gives the base affinities for animals.
 */
public class BaseAnimalAffinity {
    Random random;

    /**
     * BaseAnimalAffinity constructor.
     * 
     * @param random represents random value
     */
    public BaseAnimalAffinity(Random random) {
        this.random = random;
    }

    /**
     * base animal affinity getter.
     * 
     * @return double represents affinity
     */
    public double getAffinity() {
        double affinityBase = Math.round(random.nextDouble()) + 2 * .25;
        return affinityBase;
    }
}
