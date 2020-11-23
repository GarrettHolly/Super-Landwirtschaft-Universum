/**
 * Decorator to modify Cows Affinities.
 */
public class CowDecorator extends Animal {
    protected Cow decoratedCow;

    public CowDecorator(Cow decoratedCow) {
        this.decoratedCow = decoratedCow;
    }

    public void setAffinity() {
        decoratedCow.setAffinity();
    }

    /**
     * Getter for cow affinity.
     * 
     * @return double
     */
    public double getAffinity() {
        return decoratedCow.getAffinity();
    }

    /**
     * ToString for a decorated cow.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return decoratedCow.toString();
    }
}
