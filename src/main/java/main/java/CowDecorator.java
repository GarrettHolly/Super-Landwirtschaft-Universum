package main.java;

public class CowDecorator implements Animal {
    protected Cow decoratedCow;

    public CowDecorator(Cow decoratedCow) {
        this.decoratedCow = decoratedCow;
    }

    public void setAffinity() {
        decoratedCow.setAffinity();
    }
}
