import lombok.Getter;
import lombok.Setter;

/**
 * This class allows for chicken, cow, and sheeps to be of type Animal for the
 * list of animals.
 */
public abstract class Animal {

    /**
     * Getters and setters for the age & affinity.
     * 
     * @return int represents age
     * @return double reprsents affinity
     */
    @Getter
    @Setter
    int age = 1;
    @Getter
    double affinity;

    public Animal() {

    }
}
