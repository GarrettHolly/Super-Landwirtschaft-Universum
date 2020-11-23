/**
 * Decorator for the Chickens class.
 */
public class ChickenAffinityDecorator extends ChickenDecorator {
    private static final double affinityMultiplier = 3 + 1.5;

    public ChickenAffinityDecorator(Chicken decoratedChicken) {
        super(decoratedChicken);
    }

    @Override
    public void setAffinity() {
        decoratedChicken.setAffinity();
        decoratedChicken.affinity *= affinityMultiplier;
    }

    /**
     * ToString for a decorated chicken.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "Golden Chicken";
    }
}
