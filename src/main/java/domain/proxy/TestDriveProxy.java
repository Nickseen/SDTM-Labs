package domain.proxy;

import domain.models.CarInterface;

public class TestDriveProxy implements TestDrive {
    private RealTestDrive realTestDrive;
    private int driverAge;
    private boolean hasLicense;
    private int drivingExperience;
    
    public TestDriveProxy(int age, boolean hasLicense, int experience) {
        this.driverAge = age;
        this.hasLicense = hasLicense;
        this.drivingExperience = experience;
    }

    @Override
    public boolean checkEligibility() {
        System.out.println("\n🔍 Checking eligibility for test drive...");
        
        if (driverAge < 18) {
            System.out.println("❌ Access DENIED: Driver must be at least 18 years old.");
            System.out.println("   Your age: " + driverAge);
            return false;
        }
        
        if (!hasLicense) {
            System.out.println("❌ Access DENIED: Valid driver's license required.");
            return false;
        }
        
        if (drivingExperience < 1) {
            System.out.println("❌ Access DENIED: At least 1 year of driving experience required.");
            System.out.println("   Your experience: " + drivingExperience + " years");
            return false;
        }
        
        System.out.println("✅ Eligibility check PASSED!");
        System.out.println("   Age: " + driverAge);
        System.out.println("   License: Valid");
        System.out.println("   Experience: " + drivingExperience + " years");
        return true;
    }

    @Override
    public void startTestDrive(CarInterface car) {
        if (!checkEligibility()) {
            System.out.println("\n⛔ Test drive cannot proceed. Please meet the requirements.\n");
            return;
        }
        
        if (realTestDrive == null) {
            System.out.println("Initializing test drive system...");
            realTestDrive = new RealTestDrive();
        }
        
        System.out.println("Logging test drive request...");
        System.out.println("Driver age: " + driverAge + ", Experience: " + drivingExperience + " years");
        
        realTestDrive.startTestDrive(car);
    }
}
