package domain.models;

public class CarBuilder {
    private String model;
    private Engine engine;
    private String bodyType = "Sedan";
    private String transmission = "Manual";
    private String steeringWheelPosition = "Left";

    public CarBuilder(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public CarBuilder setBodyType(String bodyType) {
        this.bodyType = bodyType;
        return this;
    }

    public CarBuilder setTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    public CarBuilder setSteeringWheelPosition(String position) {
        this.steeringWheelPosition = position;
        return this;
    }

    public CustomCar build() {
        return new CustomCar(model, engine, bodyType, transmission, steeringWheelPosition);
    }
}
