import lombok.Getter;
import lombok.Setter;

/**
 * Gets the Chickens base affinities
 */
public class Chicken extends Animal {

    /**
     * @param animalAffinity
     * @return BaseAnimalAffinity
     */
    @Getter
    BaseAnimalAffinity animalAffinity;

    /**
     * @param animalAffinity
     * @return int
     * @param animalAffinity
     */
    @Getter
    @Setter
    int age;

    /**
     * 
     * @param animalAffinity
     */
    public Chicken(BaseAnimalAffinity animalAffinity) {
        this.animalAffinity = animalAffinity;
    }

    public void setAffinity() {
        affinity = animalAffinity.getAffinity();
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "Chicken";
    }
}
