package domain.models;

public abstract class Car {
    protected Engine engine;
    protected String name;

    public Car(String name, Engine engine) {
        this.name = name;
        this.engine = engine;
    }

    public abstract void produce();

    public String getName() {
        return name;
    }
}
