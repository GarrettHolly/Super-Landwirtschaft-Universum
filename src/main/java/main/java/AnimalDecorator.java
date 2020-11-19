package main.java;

public abstract class AnimalDecorator extends Animal {
    protected Animal decoratedAnimal;

    public AnimalDecorator(Animal decoratedAnimal) {
        this.decoratedAnimal = decoratedAnimal;
    }

    @Override
    public double getMilkAffinity() {
        return decoratedAnimal.milkAffinity;
    }

    @Override
    public double getWoolAffinity() {
        return decoratedAnimal.woolAffinity;
    }

    @Override
    public double getEggAffinity() {
        return decoratedAnimal.eggAffinity;
    }

    @Override
    public String getAnimalType() {
        return decoratedAnimal.animalType;
    }

}
