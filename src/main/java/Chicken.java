import lombok.Getter;
import lombok.Setter;

/**
 * Gets the Chickens base affinities.
 */
public class Chicken extends Animal {

    /**
     * Getters for the animalAffinity.
     * 
     * @param animalAffinity represents animals affinity
     * @return BaseAnimalAffinity returns the base animal affinites
     */
    @Getter
    BaseAnimalAffinity animalAffinity;

    /**
     * Getters and Setters for the chickens age.
     * 
     * @param animalAffinity represents animals affinity
     * @return int returnss an integer of age
     */
    @Getter
    @Setter
    int age;

    /**
     * Constructor for chicken.
     * 
     * @param animalAffinity represents animals affinty
     */
    public Chicken(BaseAnimalAffinity animalAffinity) {
        this.animalAffinity = animalAffinity;
    }

    /**
     * Setter for animal affinity.
     */
    public void setAffinity() {
        affinity = animalAffinity.getAffinity();
    }

    /**
     * ToString for chickens.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "Chicken";
    }
}
