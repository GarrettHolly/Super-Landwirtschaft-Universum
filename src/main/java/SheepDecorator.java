/**
 * Decorator to modify Sheep Affinities.
 */
public class SheepDecorator extends Animal {
    protected Sheep decoratedSheep;

    public SheepDecorator(Sheep decoratedSheep) {
        this.decoratedSheep = decoratedSheep;
    }

    public void setAffinity() {
        decoratedSheep.setAffinity();
    }

    /**
     * Getter for decorated sheep affinity.
     * 
     * @return double
     */
    public double getAffinity() {
        return decoratedSheep.getAffinity();
    }

    /**
     * ToString for decorated sheep.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return decoratedSheep.toString();
    }
}
