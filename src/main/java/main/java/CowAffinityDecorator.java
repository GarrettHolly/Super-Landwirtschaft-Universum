package main.java;

public class CowAffinityDecorator extends CowDecorator {
    private final double affinityMultiplier = 3 + 1.5;

    public CowAffinityDecorator(Cow decoratedCow) {
        super(decoratedCow);
    }

    @Override
    public void setAffinity() {
        decoratedCow.setAffinity();
        decoratedCow.affinity *= affinityMultiplier;
    }

    @Override
    public String toString() {
        return "Golden Cow";
    }
}
