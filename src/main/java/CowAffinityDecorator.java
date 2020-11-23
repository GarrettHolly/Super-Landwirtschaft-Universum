/**
 * Decorator for the Cow class.
 */
public class CowAffinityDecorator extends CowDecorator {
    private static final double affinityMultiplier = 3 + 1.5;

    public CowAffinityDecorator(Cow decoratedCow) {
        super(decoratedCow);
    }

    @Override
    public void setAffinity() {
        decoratedCow.setAffinity();
        decoratedCow.affinity *= affinityMultiplier;
    }

    /**
     * ToString for a decorated cow.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "Golden Cow";
    }
}
