package domain.decorators;

import domain.models.CarInterface;

public abstract class CarDecorator implements CarInterface {
    protected CarInterface decoratedCar;
    protected double basePrice;

    public CarDecorator(CarInterface car, double basePrice) {
        this.decoratedCar = car;
        this.basePrice = basePrice;
    }

    @Override
    public String getDescription() {
        return decoratedCar.getDescription();
    }

    @Override
    public double getPrice() {
        return basePrice;
    }

    @Override
    public void showDetails() {
        decoratedCar.showDetails();
    }
}
