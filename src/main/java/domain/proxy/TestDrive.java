package domain.proxy;

import domain.models.CarInterface;

public interface TestDrive {
    void startTestDrive(CarInterface car);
    boolean checkEligibility();
}
