import lombok.Getter;
import lombok.Setter;

/**
 * Gets the Cows base affinities.
 */
public class Cow extends Animal {
    /**
     * Getter for the animal affinity.
     * 
     * @param animalAffinity represents animals affinity
     * @return BaseAnimalAffinity returns base animal affinity
     */
    @Getter
    BaseAnimalAffinity animalAffinity;

    /**
     * Getter and setter for the animals age.
     * 
     * @param animalAffinity represents animals affinity
     * @return int returns animal age
     */
    @Getter
    @Setter
    int age;

    /**
     * Constructor for cow.
     * 
     * @param animalAffinity represents animals affinity
     */
    public Cow(BaseAnimalAffinity animalAffinity) {

        this.animalAffinity = animalAffinity;
    }

    public void setAffinity() {
        affinity = animalAffinity.getAffinity();
    }

    /**
     * ToString for cow.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "Cow";
    }
}
