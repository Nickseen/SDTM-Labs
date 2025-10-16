package factory.car;

import factory.engine.Engine;

public class GasCar extends Car {
    public GasCar(Engine engine) {
        super("Gas Car", engine);
    }

    @Override
    public void produce() {
        System.out.println("Producing " + name + " with " + engine.getType());
    }
}
