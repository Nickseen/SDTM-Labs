package domain.decorators;

import domain.models.CarInterface;

public interface PricedCar extends CarInterface {
    double getPrice();
}
