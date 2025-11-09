package domain.factory;

import domain.models.*;

public class CarFactory {
    public Car createCar(CarType type) {
        return type.createCar();
    }
}
