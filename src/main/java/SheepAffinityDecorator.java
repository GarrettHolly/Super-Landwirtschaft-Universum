/**
 * Decorator for the Sheep class.
 */
public class SheepAffinityDecorator extends SheepDecorator {
    private static final double affinityMultiplier = 3 + 1.5;

    public SheepAffinityDecorator(Sheep decoratedSheep) {
        super(decoratedSheep);
    }

    @Override
    public void setAffinity() {
        decoratedSheep.setAffinity();
        decoratedSheep.affinity *= affinityMultiplier;
    }

    /**
     * ToString for decorated sheep.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "Golden Sheep";
    }
}
