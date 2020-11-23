import lombok.Getter;
import lombok.Setter;

/**
 * Gets the sheeps base affinities.
 */
public class Sheep extends Animal {
    @Getter
    BaseAnimalAffinity animalAffinity;;
    @Getter
    @Setter

    /**
     * @param animalAffinity
     * @return BaseAnimalAffinity
     */
    int age;

    /**
     * @param animalAffinity
     * @return int
     */
    public Sheep(BaseAnimalAffinity animalAffinity) {

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
        return "Sheep";
    }

}
