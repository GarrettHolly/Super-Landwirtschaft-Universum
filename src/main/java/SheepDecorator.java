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
     * @return double
     */
    public double getAffinity() {
        return decoratedSheep.getAffinity();
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return decoratedSheep.toString();
    }
}
