package client;

import domain.models.*;
import domain.decorators.*;
import domain.proxy.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class FactoryApp {
    private List<CarInterface> createdCars = new ArrayList<>();
    
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    createCarWithAllPatterns(scanner);
                    break;
                case 2:
                    upgradeCarWithDecorator(scanner);
                    break;
                case 3:
                    testDriveWithProxy(scanner);
                    break;
                case 4:
                    showAllCars();
                    break;
                case 5:
                    System.out.println("Thank you for using Car Factory! Goodbye! 👋\n");
                    scanner.close();
                    return;
                default:
                    System.out.println(" Invalid option! Please try again.\n");
            }
        }
    }
    
    private void showMenu() {
        System.out.println("┌─────────────────────────────────────────────┐");
        System.out.println("│              MAIN MENU                      │");
        System.out.println("├─────────────────────────────────────────────┤");
        System.out.println("│ 1. Create Car (Factory+Builder+Prototype)   │");
        System.out.println("│ 2. Add Options to Car (Decorator)           │");
        System.out.println("│ 3. Request Test Drive (Proxy)               │");
        System.out.println("│ 4. Show All Created Cars                    │");
        System.out.println("│ 5. Exit                                     │");
        System.out.println("└─────────────────────────────────────────────┘");
        System.out.print("Choose option: ");
    }
    
    private void createCarWithAllPatterns(Scanner scanner) {
        System.out.println("\n========================================");
        System.out.println("  STEP 1: Factory Method Pattern");
        System.out.println("========================================");
        System.out.print("Select Engine Type (1-Gas, 2-Electric): ");
        int engineChoice = scanner.nextInt();
        scanner.nextLine();
        
        Engine engine = engineChoice == 1 ? new GasEngine() : new ElectricEngine();
        System.out.println("✓ Engine selected: " + engine.getType());
        
        System.out.println("\n========================================");
        System.out.println("  STEP 2: Builder Pattern");
        System.out.println("========================================");
        System.out.print("Body Type (Sedan/SUV/Coupe/Hatchback): ");
        String bodyType = scanner.nextLine();
        
        System.out.print("Transmission (Manual/Automatic): ");
        String transmission = scanner.nextLine();
        
        System.out.print("Steering Wheel Position (Left/Right): ");
        String steering = scanner.nextLine();
        
        CustomCar newCar = new CarBuilder("Custom Model", engine)
                .setBodyType(bodyType)
                .setTransmission(transmission)
                .setSteeringWheelPosition(steering)
                .build();
        
        System.out.println("\n✓ Car built successfully!");
        newCar.produce();
        
        createdCars.add(newCar);
        
        System.out.println("\n========================================");
        System.out.println("  STEP 3: Prototype Pattern (Optional)");
        System.out.println("========================================");
        System.out.print("Do you want to clone this car with a body kit model? (yes/no): ");
        String cloneChoice = scanner.nextLine();
        
        if (cloneChoice.equalsIgnoreCase("yes")) {
            System.out.println("\nAvailable Body Kit Models:");
            
            BodyKitModel[] models = BodyKitModel.values();
            for (int i = 0; i < models.length; i++) {
                System.out.println((i + 1) + ". " + models[i].getDescription());
            }
            
            System.out.print("\nSelect body kit model (1-" + models.length + "): ");
            int modelChoice = scanner.nextInt();
            scanner.nextLine();
            
            CustomCar clonedCar = newCar.clone();
            System.out.println("\nCar cloned successfully!");
            
            BodyKitModel selectedModel = BodyKitModel.fromChoice(modelChoice);
            if (selectedModel != null) {
                selectedModel.applyTo(clonedCar);
                System.out.println("Applied: " + selectedModel.getDisplayName());
            } else {
                System.out.println("Invalid choice, no kits applied.");
            }
            
            System.out.println("\n=== Cloned Car with Body Kit Model ===");
            clonedCar.produce();
            
            createdCars.add(clonedCar);
        } else {
            System.out.println("\nSkipping prototype pattern.");
            newCar.produce();
        }
        
        System.out.println("\n========================================");
        System.out.println("  Summary: Total cars created: " + createdCars.size());
        System.out.println("========================================");
        System.out.println();
    }
    
    private void upgradeCarWithDecorator(Scanner scanner) {
        if (createdCars.isEmpty()) {
            System.out.println(" No cars available. Create a car first!\n");
            return;
        }
        
        System.out.println("═══ Decorator Pattern - Add Options ═══");
        System.out.println("Select car to add options:");
        for (int i = 0; i < createdCars.size(); i++) {
            System.out.println((i + 1) + ". " + createdCars.get(i).getDescription());
        }
        
        System.out.print("\nChoice: ");
        int carIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (carIndex < 0 || carIndex >= createdCars.size()) {
            System.out.println(" Invalid selection!\n");
            return;
        }
        
        CarInterface selectedCar = createdCars.get(carIndex);
        
        System.out.println("\n  Available Options:");
        System.out.println("1. GPS Navigation System");
        System.out.println("2. Leather Seats");
        System.out.println("3. Panoramic Sunroof");
        System.out.println("4. Premium Audio System");
        System.out.println("5. All Options (Premium Package)");
        
        System.out.print("\nSelect option to add: ");
        int optionChoice = scanner.nextInt();
        scanner.nextLine();
        
        CarOption option = CarOption.fromChoice(optionChoice);
        
        if (option == null) {
            System.out.println(" Invalid option!\n");
            return;
        }
        
        CarInterface decoratedCar = option.applyTo(selectedCar);
        System.out.println("\n✓ " + option.getDisplayName() + " added!");
        
        decoratedCar.showDetails();
        createdCars.set(carIndex, decoratedCar);
        System.out.println();
    }
    
    private void testDriveWithProxy(Scanner scanner) {
        if (createdCars.isEmpty()) {
            System.out.println(" No cars available for test drive. Create a car first!\n");
            return;
        }
        
        System.out.println("═══ Proxy Pattern - Test Drive Access Control ═══");
        
        System.out.print("Your age: ");
        int age = scanner.nextInt();
        
        System.out.print("Do you have a driver's license? (yes/no): ");
        scanner.nextLine();
        String licenseInput = scanner.nextLine();
        boolean hasLicense = licenseInput.equalsIgnoreCase("yes");
        
        System.out.print("Years of driving experience: ");
        int experience = scanner.nextInt();
        scanner.nextLine();
        
        TestDrive testDriveProxy = new TestDriveProxy(age, hasLicense, experience);
        
        System.out.println("\nSelect car for test drive:");
        for (int i = 0; i < createdCars.size(); i++) {
            System.out.println((i + 1) + ". " + createdCars.get(i).getDescription());
        }
        
        System.out.print("\nChoice: ");
        int carIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (carIndex < 0 || carIndex >= createdCars.size()) {
            System.out.println(" Invalid selection!\n");
            return;
        }
        
        CarInterface selectedCar = createdCars.get(carIndex);
        
        testDriveProxy.startTestDrive(selectedCar);
        System.out.println();
    }
    
    private void showAllCars() {
        if (createdCars.isEmpty()) {
            System.out.println(" No cars created yet!\n");
            return;
        }
        
        System.out.println("═══ All Created Cars ═══");
        for (int i = 0; i < createdCars.size(); i++) {
            System.out.println("\n" + (i + 1) + ".");
            createdCars.get(i).showDetails();
        }
        System.out.println();
    }
}
