package factory.production;

import factory.car.*;

public class FactoryApp {
    public void run() {
        CarFactory factory = new CarFactory();

        Car gasCar = factory.createCar(CarType.GAS);
        gasCar.produce();

        Car electricCar = factory.createCar(CarType.ELECTRIC);
        electricCar.produce();
    }
}
