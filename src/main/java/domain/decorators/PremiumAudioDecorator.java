package domain.decorators;

import domain.models.CarInterface;

public class PremiumAudioDecorator extends CarDecorator {
    
    public PremiumAudioDecorator(CarInterface car) {
        super(car, 0); // Не добавляем цену, просто опцию
    }

    @Override
    public String getDescription() {
        return decoratedCar.getDescription() + " + Premium Audio System";
    }

    @Override
    public void showDetails() {
        decoratedCar.showDetails();
        System.out.println("Premium Audio System");
    }
}
