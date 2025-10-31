package client;

import domain.models.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class FactoryApp {
    private List<CustomCar> customCars = new ArrayList<>();
    
    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Car Factory - Creational Design Patterns ===\n");

        while (true) {
            System.out.println("1. Create Car (All 3 Patterns Combined)");
            System.out.println("2. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createCarWithAllPatterns(scanner);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option!\n");
            }
        }
    }
    
    private void createCarWithAllPatterns(Scanner scanner) {
        System.out.println("\n========================================");
        System.out.println("  STEP 1: Factory Method Pattern");
        System.out.println("========================================");
        System.out.print("Select Engine Type (1-Gas, 2-Electric): ");
        int engineChoice = scanner.nextInt();
        scanner.nextLine();
        
        // Factory Method Pattern - Create engine
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
        
        // Builder Pattern - Build custom car
        CustomCar newCar = new CarBuilder("Custom Model", engine)
                .setBodyType(bodyType)
                .setTransmission(transmission)
                .setSteeringWheelPosition(steering)
                .build();
        
        System.out.println("\n✓ Car built successfully!");
        newCar.produce();
        
        customCars.add(newCar);
        
        System.out.println("\n========================================");
        System.out.println("  STEP 3: Prototype Pattern (Optional)");
        System.out.println("========================================");
        System.out.print("Do you want to clone this car with a body kit model? (yes/no): ");
        String cloneChoice = scanner.nextLine();
        
        if (cloneChoice.equalsIgnoreCase("yes")) {
            System.out.println("\nAvailable Body Kit Models:");
            
            // Display all available models dynamically
            BodyKitModel[] models = BodyKitModel.values();
            for (int i = 0; i < models.length; i++) {
                System.out.println((i + 1) + ". " + models[i].getDescription());
            }
            
            System.out.print("\nSelect body kit model (1-" + models.length + "): ");
            int modelChoice = scanner.nextInt();
            scanner.nextLine();
            
            // Prototype Pattern - Clone the car
            CustomCar clonedCar = newCar.clone();
            System.out.println("\nCar cloned successfully!");
            
            // Apply body kit using OCP-compliant approach
            BodyKitModel selectedModel = BodyKitModel.fromChoice(modelChoice);
            if (selectedModel != null) {
                selectedModel.applyTo(clonedCar);
                System.out.println("Applied: " + selectedModel.getDisplayName());
            } else {
                System.out.println("Invalid choice, no kits applied.");
            }
            
            System.out.println("\n=== Cloned Car with Body Kit Model ===");
            clonedCar.produce();
            
            customCars.add(clonedCar);
        } else {
            System.out.println("\nSkipping prototype pattern.");
            newCar.produce();
        }
        
        System.out.println("\n========================================");
        System.out.println("  Summary: Total cars created: " + customCars.size());
        System.out.println("========================================");
    }
}
