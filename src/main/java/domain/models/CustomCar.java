package domain.models;

import java.util.ArrayList;
import java.util.List;

public class CustomCar extends Car implements Cloneable {
    private String bodyType;
    private String transmission;
    private String steeringWheelPosition;
    private List<String> bodyKits;

    public CustomCar(String model, Engine engine, String bodyType, String transmission, String steeringWheelPosition) {
        super(model, engine);
        this.bodyType = bodyType;
        this.transmission = transmission;
        this.steeringWheelPosition = steeringWheelPosition;
        this.bodyKits = new ArrayList<>();
    }

    @Override
    public CustomCar clone() {
        try {
            CustomCar cloned = (CustomCar) super.clone();
            cloned.bodyKits = new ArrayList<>(this.bodyKits);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }

    public void addBodyKit(String kit) {
        bodyKits.add(kit);
    }

    @Override
    public void produce() {
        showDetails();
    }

    @Override
    public void showDetails() {
        System.out.println("=== Custom Car Details ===");
        System.out.println("Model: " + name);
        System.out.println("Engine: " + engine.getType());
        System.out.println("Body Type: " + bodyType);
        System.out.println("Transmission: " + transmission);
        System.out.println("Steering Wheel: " + steeringWheelPosition);
        if (!bodyKits.isEmpty()) {
            System.out.println("Body Kits: " + String.join(", ", bodyKits));
        }
        System.out.println("==========================");
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getSteeringWheelPosition() {
        return steeringWheelPosition;
    }

    public List<String> getBodyKits() {
        return bodyKits;
    }
}

