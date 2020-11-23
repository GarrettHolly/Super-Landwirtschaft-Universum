package main.java;

/**
 * Decorator to modify Cows Affinities
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
     * @return double
     */
    public double getAffinity() {
        return decoratedCow.getAffinity();
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return decoratedCow.toString();
    }
}
