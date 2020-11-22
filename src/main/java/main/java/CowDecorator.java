package main.java;

public class CowDecorator extends Animal {
    protected Cow decoratedCow;

    public CowDecorator(Cow decoratedCow) {
        this.decoratedCow = decoratedCow;
    }

    public void setAffinity() {
        decoratedCow.setAffinity();
    }

    public double getAffinity() {
        return decoratedCow.getAffinity();
    }

    @Override
    public String toString() {
        return decoratedCow.toString();
    }
}
