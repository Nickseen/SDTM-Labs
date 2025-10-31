package domain.decorators;

import domain.models.CarInterface;

public class SunroofDecorator extends CarDecorator {
    
    public SunroofDecorator(CarInterface car) {
        super(car, 0); // Не добавляем цену, просто опцию
    }

    @Override
    public String getDescription() {
        return decoratedCar.getDescription() + " + Panoramic Sunroof";
    }

    @Override
    public void showDetails() {
        decoratedCar.showDetails();
        System.out.println("Panoramic Sunroof");
    }
}
