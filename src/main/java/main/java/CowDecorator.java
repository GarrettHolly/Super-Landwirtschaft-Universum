package main.java;

public class CowDecorator extends Cow {
    protected Cow decoratedCow;

    public CowDecorator(Cow decoratedCow, AnimalAffinity animalAffinity) {
        super(animalAffinity);
        this.decoratedCow = decoratedCow;
    }

    @Override
    public double getAffinity() {
        return decoratedCow.getAffinity();
    }
}
