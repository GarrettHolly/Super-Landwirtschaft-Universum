package main.java;

public abstract class AnimalDecorator extends Animal {
    protected Animal decoratedAnimal;

    public AnimalDecorator(Animal decoratedAnimal) {
        this.decoratedAnimal = decoratedAnimal;
    }

    /**
     * @return double
     */
    @Override
    public double getMilkAffinity() {
        return decoratedAnimal.milkAffinity;
    }

    /**
     * @return double
     */
    @Override
    public double getWoolAffinity() {
        return decoratedAnimal.woolAffinity;
    }

    /**
     * @return double
     */
    @Override
    public double getEggAffinity() {
        return decoratedAnimal.eggAffinity;
    }

    /**
     * @return String
     */
    @Override
    public String getAnimalType() {
        return decoratedAnimal.animalType;
    }

}
