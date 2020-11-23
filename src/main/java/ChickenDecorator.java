/**
 * Decorator to modify Chickens Affinities
 */
public abstract class ChickenDecorator extends Animal {
    protected Chicken decoratedChicken;

    public ChickenDecorator(Chicken decoratedChicken) {
        this.decoratedChicken = decoratedChicken;
    }

    public void setAffinity() {
        decoratedChicken.setAffinity();
    }

    /**
     * @return double
     */
    public double getAffinity() {
        return decoratedChicken.getAffinity();
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return decoratedChicken.toString();
    }
}
