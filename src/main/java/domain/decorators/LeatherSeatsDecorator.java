package domain.decorators;

import domain.models.CarInterface;

public class LeatherSeatsDecorator extends CarDecorator {
    
    public LeatherSeatsDecorator(CarInterface car) {
        super(car, 0); // Не добавляем цену, просто опцию
    }

    @Override
    public String getDescription() {
        return decoratedCar.getDescription() + " + Leather Seats";
    }

    @Override
    public void showDetails() {
        decoratedCar.showDetails();
        System.out.println("Leather Seats");
    }
}
