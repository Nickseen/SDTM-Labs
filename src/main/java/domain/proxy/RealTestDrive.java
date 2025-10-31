package domain.proxy;

import domain.models.CarInterface;

public class RealTestDrive implements TestDrive {
    
    @Override
    public void startTestDrive(CarInterface car) {
        System.out.println("\n🚗 ========== TEST DRIVE STARTED ==========");
        System.out.println("Starting engine of: " + car.getDescription());
        System.out.println("Accelerating...");
        System.out.println("Testing brakes...");
        System.out.println("Testing handling...");
        System.out.println("Test drive completed successfully!");
        System.out.println("===========================================\n");
    }

    @Override
    public boolean checkEligibility() {
        return true;
    }
}
