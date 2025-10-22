package domain.models;

public enum CarType {
    GAS {
        @Override
        public Car createCar() {
            return new GasCar(new GasEngine());
        }
    },
    ELECTRIC {
        @Override
        public Car createCar() {
            return new ElectricCar(new ElectricEngine());
        }
    };

    public abstract Car createCar();

}
