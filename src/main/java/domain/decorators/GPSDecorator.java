package domain.decorators;

import domain.models.CarInterface;

public class GPSDecorator extends CarDecorator {
    
    public GPSDecorator(CarInterface car) {
        super(car, 0); // Не добавляем цену, просто опцию
    }

    @Override
    public String getDescription() {
        return decoratedCar.getDescription() + " + GPS Navigation";
    }

    @Override
    public void showDetails() {
        decoratedCar.showDetails();
        System.out.println("    GPS Navigation System");
    }
}
