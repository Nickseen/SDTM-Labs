package domain.models;

public class ElectricCar extends Car {
    public ElectricCar(Engine engine) {
        super("Electric Car", engine);
    }

    @Override
    public void produce() {
        System.out.println("Producing " + name + " with " + engine.getType());
    }
}
