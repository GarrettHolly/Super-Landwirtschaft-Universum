/**
 * Decorator to modify Chickens Affinities.
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
     * Gets affinity for a decorated chicken.
     * 
     * @return double
     */
    public double getAffinity() {
        return decoratedChicken.getAffinity();
    }

    /**
     * ToString for the decorated chicken.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return decoratedChicken.toString();
    }
}
