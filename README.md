# Factory Design Pattern with SOLID Principles

This project demonstrates the implementation of a Car Factory system using three SOLID principles:

## SOLID Principles Implemented

### 1. Single Responsibility Principle (S)
- Each class has one specific responsibility:
  - `Car`: Represents a car with basic properties
  - `Engine`: Handles engine-specific functionality
  - `CarFactory`: Manages car creation
  - Different car types (`ElectricCar`, `GasCar`) handle their specific implementations

### 2. Open-Closed Principle (O)
- The system is open for extension but closed for modification:
  - New car types can be added by extending the `Car` class
  - New engine types can be added by implementing the `Engine` interface
  - No need to modify existing code when adding new car or engine types

### 3. Dependency Inversion Principle (D)
- High-level modules don't depend on low-level modules; both depend on abstractions:
  - Cars depend on the `Engine` interface rather than concrete engine implementations
  - `CarFactory` works with abstract `Car` class rather than concrete implementations
  - This allows for easy swapping of components without changing the core logic

## Project Structure

```
src/main/java/factory/
├── car/
│   ├── Car.java
│   ├── CarType.java
│   ├── ElectricCar.java
│   └── GasCar.java
├── engine/
│   ├── Engine.java
│   ├── ElectricEngine.java
│   └── GasEngine.java
└── production/
    ├── CarFactory.java
    └── FactoryApp.java
```

## How to Run

To compile and run the project:

```bash
mvn compile exec:java
```

## Implementation Details

- **Car Factory System**: Demonstrates the creation of different types of cars (Electric and Gas) using a factory pattern
- **Abstraction**: Uses interfaces and abstract classes to maintain loose coupling
- **Extensibility**: New car types can be added without modifying existing code
- **Maintainability**: Each class has a single responsibility, making the code easier to maintain and test

## Benefits of SOLID Implementation

1. **Better Maintainability**: Each class has a single responsibility, making it easier to understand and modify
2. **Easier Extensions**: New features can be added without changing existing code
3. **Loose Coupling**: Dependencies are on abstractions rather than concrete implementations
4. **Improved Testability**: Classes with single responsibilities are easier to test
5. **Flexibility**: Easy to swap implementations due to dependency inversion
