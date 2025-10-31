package domain.models;

public abstract class Car implements CarInterface {
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

    @Override
    public String getDescription() {
        return name + " with " + engine.getType();
    }

    @Override
    public void showDetails() {
        System.out.println("=== Car Details ===");
        System.out.println("Model: " + getDescription());
        System.out.println("==================");
    }
}
