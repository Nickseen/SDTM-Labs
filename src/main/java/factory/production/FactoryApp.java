package factory.production;

import factory.car.*;
import java.util.Scanner;

public class FactoryApp {
    public void run() {
        CarFactory factory = new CarFactory();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Car Factory - SOLID Principles Demo ===\n");

        while (true) {
            System.out.println("1. Produce Gas Car");
            System.out.println("2. Produce Electric Car");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Car gasCar = factory.createCar(CarType.GAS);
                    gasCar.produce();
                    System.out.println();
                    break;
                case 2:
                    Car electricCar = factory.createCar(CarType.ELECTRIC);
                    electricCar.produce();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option!\n");
            }
        }
    }
}
