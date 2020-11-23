import lombok.Getter;
import lombok.Setter;

/**
 * Gets the Cows base affinities
 */
public class Cow extends Animal {
    @Getter
    BaseAnimalAffinity animalAffinity;
    /**
     * @param animalAffinity
     * @return BaseAnimalAffinity
     * @param animalAffinity
     * @return int
     */
    @Getter
    @Setter
    int age;

    /**
     * @param animalAffinity
     */
    public Cow(BaseAnimalAffinity animalAffinity) {

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
        return "Cow";
    }
}
