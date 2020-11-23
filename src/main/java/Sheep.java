import lombok.Getter;
import lombok.Setter;

/**
 * Gets the sheeps base affinities.
 */
public class Sheep extends Animal {
    /**
     * Getter for base animal affinity.
     * 
     * @param animalAffinity represents animals affinity
     * @return BaseAnimalAffinity
     */
    @Getter
    BaseAnimalAffinity animalAffinity;
    /**
     * Getter and Setter for animal age.
     * 
     * @return int
     */
    @Getter
    @Setter
    int age;

    /**
     * Constructor for sheep.
     * 
     * @param animalAffinity represents animals affinity
     */
    public Sheep(BaseAnimalAffinity animalAffinity) {

        this.animalAffinity = animalAffinity;
    }

    public void setAffinity() {
        affinity = animalAffinity.getAffinity();
    }

    /**
     * ToString for sheep.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "Sheep";
    }

}
