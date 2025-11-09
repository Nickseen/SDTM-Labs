package domain.decorators;

import domain.models.CarInterface;

public enum CarOption {
    GPS("GPS Navigation System") {
        @Override
        public CarInterface applyTo(CarInterface car) {
            return new GPSDecorator(car);
        }
    },
    
    LEATHER_SEATS("Leather Seats") {
        @Override
        public CarInterface applyTo(CarInterface car) {
            return new LeatherSeatsDecorator(car);
        }
    },
    
    SUNROOF("Panoramic Sunroof") {
        @Override
        public CarInterface applyTo(CarInterface car) {
            return new SunroofDecorator(car);
        }
    },
    
    PREMIUM_AUDIO("Premium Audio System") {
        @Override
        public CarInterface applyTo(CarInterface car) {
            return new PremiumAudioDecorator(car);
        }
    },
    
    ALL_OPTIONS("All Premium Options") {
        @Override
        public CarInterface applyTo(CarInterface car) {
            CarInterface decorated = car;
            decorated = new GPSDecorator(decorated);
            decorated = new LeatherSeatsDecorator(decorated);
            decorated = new SunroofDecorator(decorated);
            decorated = new PremiumAudioDecorator(decorated);
            return decorated;
        }
    };

    private final String displayName;

    CarOption(String displayName) {
        this.displayName = displayName;
    }

    public abstract CarInterface applyTo(CarInterface car);

    public String getDisplayName() {
        return displayName;
    }

    public static CarOption fromChoice(int choice) {
        if (choice < 1 || choice > values().length) {
            return null;
        }
        return values()[choice - 1];
    }
}
