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
                    purchaseCarWithPaymentStrategy(scanner);
                    break;
                case 4:
                    testDriveWithProxy(scanner);
                    break;
                case 5:
                    showAllCars();
                    break;
                case 6:
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
        System.out.println("│ 1. Create Car (with Command undo/redo)      │");
        System.out.println("│ 2. Add Options to Car (Decorator)           │");
        System.out.println("│ 3. Purchase Car (Payment Strategy)          │");
        System.out.println("│ 4. Request Test Drive (Proxy)               │");
        System.out.println("│ 5. Show All Created Cars                    │");
        System.out.println("│ 6. Exit                                     │");
        System.out.println("└─────────────────────────────────────────────┘");
        System.out.print("Choose option: ");
    }
    
    private void createCarWithAllPatterns(Scanner scanner) {
        domain.command.CommandHistory history = new domain.command.CommandHistory();
        
        // Use arrays to allow modification by commands
        Engine[] engineHolder = new Engine[1];
        String[] bodyTypeHolder = new String[1];
        String[] transmissionHolder = new String[1];
        String[] steeringHolder = new String[1];
        
        System.out.println("\n========================================");
        System.out.println("  Car Configuration with Command Pattern");
        System.out.println("  (u=undo, r=redo at each step)");
        System.out.println("========================================");
        
        int currentStep = 1;
        
        while (currentStep <= 4) {
            if (currentStep == 1) {
                System.out.println("\n--- STEP 1: Select Engine Type ---");
                String current = (engineHolder[0] != null) ? engineHolder[0].getType() : "None";
                System.out.println("Current: " + current);
                System.out.print("Choose (1-Gas, 2-Electric, u-undo, r-redo): ");
                String input = scanner.nextLine().trim();
                
                if (input.equalsIgnoreCase("u")) {
                    if (history.canUndo()) {
                        history.undo();
                        currentStep = Math.max(1, currentStep - 1);
                    } else {
                        System.out.println("Nothing to undo.");
                    }
                } else if (input.equalsIgnoreCase("r")) {
                    if (history.canRedo()) {
                        history.redo();
                        currentStep++;
                    } else {
                        System.out.println("Nothing to redo.");
                    }
                } else {
                    try {
                        int choice = Integer.parseInt(input);
                        if (choice == 1 || choice == 2) {
                            Engine engine = (choice == 1) ? new GasEngine() : new ElectricEngine();
                            domain.command.ChooseEngineCommand cmd = new domain.command.ChooseEngineCommand(engineHolder, engine);
                            history.execute(cmd);
                            currentStep++;
                        } else {
                            System.out.println("Invalid choice! Please select 1 or 2.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input!");
                    }
                }
            } else if (currentStep == 2) {
                System.out.println("\n--- STEP 2: Select Body Type ---");
                String current = (bodyTypeHolder[0] != null) ? bodyTypeHolder[0] : "None";
                System.out.println("Current: " + current);
                System.out.print("Enter Body Type (Sedan/SUV/Coupe/Hatchback, u-undo, r-redo): ");
                String input = scanner.nextLine().trim();
                
                if (input.equalsIgnoreCase("u")) {
                    if (history.canUndo()) {
                        history.undo();
                        currentStep--;
                    } else {
                        System.out.println("Nothing to undo.");
                    }
                } else if (input.equalsIgnoreCase("r")) {
                    if (history.canRedo()) {
                        history.redo();
                        currentStep++;
                    } else {
                        System.out.println("Nothing to redo.");
                    }
                } else if (!input.isEmpty()) {
                    domain.command.SetBodyTypeCommand cmd = new domain.command.SetBodyTypeCommand(bodyTypeHolder, input);
                    history.execute(cmd);
                    currentStep++;
                } else {
                    System.out.println("Body type cannot be empty!");
                }
            } else if (currentStep == 3) {
                System.out.println("\n--- STEP 3: Select Transmission ---");
                String current = (transmissionHolder[0] != null) ? transmissionHolder[0] : "None";
                System.out.println("Current: " + current);
                System.out.print("Enter Transmission (Manual/Automatic, u-undo, r-redo): ");
                String input = scanner.nextLine().trim();
                
                if (input.equalsIgnoreCase("u")) {
                    if (history.canUndo()) {
                        history.undo();
                        currentStep--;
                    } else {
                        System.out.println("Nothing to undo.");
                    }
                } else if (input.equalsIgnoreCase("r")) {
                    if (history.canRedo()) {
                        history.redo();
                        currentStep++;
                    } else {
                        System.out.println("Nothing to redo.");
                    }
                } else if (!input.isEmpty()) {
                    domain.command.SetTransmissionCommand cmd = new domain.command.SetTransmissionCommand(transmissionHolder, input);
                    history.execute(cmd);
                    currentStep++;
                } else {
                    System.out.println("Transmission cannot be empty!");
                }
            } else if (currentStep == 4) {
                System.out.println("\n--- STEP 4: Select Steering Wheel Position ---");
                String current = (steeringHolder[0] != null) ? steeringHolder[0] : "None";
                System.out.println("Current: " + current);
                System.out.print("Enter Position (Left/Right, u-undo, r-redo): ");
                String input = scanner.nextLine().trim();
                
                if (input.equalsIgnoreCase("u")) {
                    if (history.canUndo()) {
                        history.undo();
                        currentStep--;
                    } else {
                        System.out.println("Nothing to undo.");
                    }
                } else if (input.equalsIgnoreCase("r")) {
                    if (history.canRedo()) {
                        history.redo();
                        currentStep++;
                    } else {
                        System.out.println("Nothing to redo.");
                    }
                } else if (!input.isEmpty()) {
                    domain.command.SetSteeringCommand cmd = new domain.command.SetSteeringCommand(steeringHolder, input);
                    history.execute(cmd);
                    currentStep++;
                } else {
                    System.out.println("Steering position cannot be empty!");
                }
            }
        }
        
        // Build the car using Builder pattern
        System.out.println("\n========================================");
        System.out.println("  Building Car with Selected Options...");
        System.out.println("========================================");
        
        CustomCar newCar = new CarBuilder("Custom Model", engineHolder[0])
                .setBodyType(bodyTypeHolder[0])
                .setTransmission(transmissionHolder[0])
                .setSteeringWheelPosition(steeringHolder[0])
                .build();
        
        System.out.println("\n✓ Car built successfully!");
        newCar.produce();
        
        createdCars.add(newCar);
        
        // STEP 5: Prototype Pattern (Optional)
        System.out.println("\n========================================");
        System.out.println("  STEP 5: Prototype Pattern (Optional)");
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

    private void purchaseCarWithPaymentStrategy(Scanner scanner) {
        if (createdCars.isEmpty()) {
            System.out.println(" No cars available. Create a car first!\n");
            return;
        }

        System.out.println("═══ Purchase - Payment Strategy Demo ═══");
        System.out.println("Select car to purchase:");
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

        CarInterface selected = createdCars.get(carIndex);
        double amount = selected.getPrice();
        if (amount <= 0) {
            System.out.println("Price not available for this car. Using sample price $30000.00");
            amount = 30000.0;
        }

        System.out.println("Select payment method:");
        System.out.println("1. Cash");
        System.out.println("2. Card");
        System.out.println("3. Leasing");
        System.out.print("Choice: ");
        int payChoice = scanner.nextInt();
        scanner.nextLine();

        domain.strategy.PaymentStrategy strategy;
        switch (payChoice) {
            case 1:
                strategy = new domain.strategy.CashPayment();
                break;
            case 2:
                strategy = new domain.strategy.CardPayment();
                break;
            case 3:
                strategy = new domain.strategy.LeasingPayment();
                break;
            default:
                System.out.println("Invalid payment method!\n");
                return;
        }

        System.out.println("Executing payment via: " + strategy.getName());
        boolean ok = strategy.pay(amount);
        if (ok) {
            System.out.println("Purchase completed for: " + selected.getDescription() + "\n");
        } else {
            System.out.println("Payment failed.\n");
        }
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
