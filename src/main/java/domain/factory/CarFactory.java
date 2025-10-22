package domain.factory;

import domain.models.*;

public class CarFactory {
    public Car createCar(CarType type) {
        return switch (type) {
            case GAS -> new GasCar(new GasEngine());
            case ELECTRIC -> new ElectricCar(new ElectricEngine());
        };
    }
}
