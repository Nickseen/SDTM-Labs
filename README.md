# Car Factory - SOLID Principles Demo

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.1.0-blue.svg)](https://maven.apache.org/)

## Overview

A Java project demonstrating SOLID principles implementation through a Car Factory system. This project is part of the SDTM-Labs repository and showcases clean code architecture and object-oriented design patterns focusing on:

- Single Responsibility Principle (SRP)
- Open/Closed Principle (OCP)
- Dependency Inversion Principle (DIP)

## Architecture

The system implements a car manufacturing process using:
- Factory pattern for object creation
- Interface-based dependency injection
- Abstract base classes for extensibility

### Key Components
- Abstract car factory for flexible vehicle creation
- Engine interface for dependency injection
- Concrete implementations for gas and electric vehicles

## Project Structure

```
src/main/java/factory/
├── Main.java                    # Application entry point
├── car/
│   ├── Car.java                # Abstract base class
│   ├── CarType.java            # Car type enumeration
│   ├── ElectricCar.java        # Electric car implementation
│   └── GasCar.java             # Gas car implementation
├── engine/
│   ├── Engine.java             # Engine interface
│   ├── ElectricEngine.java     # Electric engine implementation
│   └── GasEngine.java          # Gas engine implementation
└── production/
    ├── CarFactory.java         # Factory for car creation
    └── FactoryApp.java         # Application orchestrator
```

## Implementation Details

```

src/main/java/factory/- **SRP (Single Responsibility Principle)**

├── Main.java                    # Application entry point

├── car/- **OCP (Open/Closed Principle)** ## ⚙️ SOLID Principles Used

│   ├── Car.java                # Abstract base class

│   ├── CarType.java            # Enumeration for car types- **DIP (Dependency Inversion Principle)**- **SRP**: Each class handles one responsibility (e.g., `Car`, `Engine`, `CarFactory`).

│   ├── ElectricCar.java        # Electric car implementation

│   └── GasCar.java             # Gas car implementation- **OCP**: Adding new car types (e.g., HybridCar) doesn’t change existing code.

├── engine/

│   ├── Engine.java             # Engine interface (abstraction)The system creates different types of cars (Gas and Electric) using a factory pattern with proper abstraction and dependency injection.- **DIP**: Cars depend on the abstract `Engine` interface, not concrete implementations.

│   ├── ElectricEngine.java     # Electric engine implementation

│   └── GasEngine.java          # Gas engine implementation

└── production/

    ├── CarFactory.java         # Factory for creating cars## 🏗️ Architecture## ▶️ Run with Maven

    └── FactoryApp.java         # Application orchestrator

``````bash



## 🔧 SOLID Principles Implementation```mvn compile exec:java"



### 🎯 **SRP (Single Responsibility Principle)**src/main/java/factory/```

Each class has a single, well-defined responsibility:

├── Main.java                    # Application entry point

```java

// Engine interface - Only defines engine behavior├── car/## 🧩 Example Output

public interface Engine {

    String getType();│   ├── Car.java                # Abstract base class```

}

│   ├── CarType.java            # Enumeration for car typesProducing Gas Car with Gas Engine

// Car class - Only manages car properties and behavior

public abstract class Car {│   ├── ElectricCar.java        # Electric car implementationProducing Electric Car with Electric Engine

    protected Engine engine;

    protected String name;│   └── GasCar.java             # Gas car implementation```

    public abstract void produce();

}├── engine/

```│   ├── Engine.java             # Engine interface (abstraction)

│   ├── ElectricEngine.java     # Electric engine implementation

**Key Lines:**│   └── GasEngine.java          # Gas engine implementation

- `public interface Engine` - Single responsibility for engine behavior└── production/

- `public abstract class Car` - Single responsibility for car structure    ├── CarFactory.java         # Factory for creating cars

- `public class CarFactory` - Single responsibility for car creation    └── FactoryApp.java         # Application orchestrator

```

### 🔓 **OCP (Open/Closed Principle)**

The system is open for extension but closed for modification:## 🔧 SOLID Principles Implementation



```java### 🎯 **SRP (Single Responsibility Principle)**

// Adding new car types doesn't modify existing codeEach class has a single, well-defined responsibility:

public class HybridCar extends Car {  // ← Extension without modification

    // New implementation```java

}// Engine interface - Only defines engine behavior

```public interface Engine {

    String getType();

**Key Lines:**}

- `abstract class Car` - Open for extension via inheritance

- `implements Engine` - Open for extension via interface implementation// Car class - Only manages car properties and behavior

- `extends Car` - Extension mechanism in actionpublic abstract class Car {

    protected Engine engine;

### ⬇️ **DIP (Dependency Inversion Principle)**    protected String name;

High-level modules depend on abstractions, not concretions:    public abstract void produce();

}

```java```

public abstract class Car {

    protected Engine engine;  // ← Depends on abstraction (Engine interface)**Key Lines:**

    - `public interface Engine` - Single responsibility for engine behavior

    public Car(String name, Engine engine) {  // ← Dependency injection- `public abstract class Car` - Single responsibility for car structure

        this.engine = engine;- `public class CarFactory` - Single responsibility for car creation

    }

}### 🔓 **OCP (Open/Closed Principle)**

```The system is open for extension but closed for modification:



**Key Lines:**```java

- `Engine engine` - Dependency on abstraction// Adding new car types doesn't modify existing code

- Constructor injection - Inversion of controlpublic class HybridCar extends Car {  // ← Extension without modification

- `engine.getType()` - Using interface, not concrete implementation    // New implementation

}

## Build and Run

### Prerequisites
- Java 21 or higher
- Maven 3.6+
- Git

### Setup
1. Clone the repository:
```bash
git clone https://github.com/Nickseen/SDTM-Labs.git
cd SDTM-Labs
git checkout lab0
```

2. Build and run:
```bash
# Using Maven
mvn compile
mvn exec:java -Dexec.mainClass="factory.Main"

# Alternative manual compilation
javac -d target/classes src/main/java/factory/**/*.java
java -cp target/classes factory.Main
```

High-level modules depend on abstractions, not concretions:

1. **Clone the repository and switch to lab0 branch**

   ```bash```java

   git clone https://github.com/Nickseen/SDTM-Labs.gitpublic abstract class Car {

   cd SDTM-Labs    protected Engine engine;  // ← Depends on abstraction (Engine interface)

   git checkout lab0    

   ```    public Car(String name, Engine engine) {  // ← Dependency injection

        this.engine = engine;

2. **Compile the project**    }

   ```bash}

   mvn compile```

   ```

**Key Lines:**

3. **Run the application**- `Engine engine` - Dependency on abstraction

   ```bash- Constructor injection - Inversion of control

   mvn exec:java- `engine.getType()` - Using interface, not concrete implementation

   ```

   ## 🚀 Getting Started

   Or with explicit main class:

   ```bash### Prerequisites

   mvn compile exec:java -Dexec.mainClass="factory.Main"- Java 21 or higher

   ```- Maven 3.6+ 

- Git

### Alternative Execution

### Installation

If you prefer manual compilation:

```bash1. **Clone the repository**

# Compile   ```bash

javac -d target/classes src/main/java/factory/**/*.java   git clone https://github.com/yourusername/SDTM-Labs.git

   cd SDTM-Labs

# Run   ```

java -cp target/classes factory.Main

```2. **Compile the project**

   ```bash

## 📊 Example Output   mvn compile

   ```

```

Producing Gas Car with Gas Engine3. **Run the application**

Producing Electric Car with Electric Engine   ```bash

```   mvn exec:java

   ```

## 🧪 Testing the Principles   

   Or with explicit main class:

### Adding New Car Types (OCP Demo)   ```bash

```java   mvn compile exec:java -Dexec.mainClass="factory.Main"

// Add this without modifying existing code:   ```

public class HybridCar extends Car {

    public HybridCar(Engine engine) {### Alternative Execution

        super("Hybrid Car", engine);

    }If you prefer manual compilation:

    ```bash

    @Override# Compile

    public void produce() {javac -d target/classes src/main/java/factory/**/*.java

        System.out.println("Producing " + name + " with " + engine.getType());

    }# Run

}java -cp target/classes factory.Main

``````



### Adding New Engine Types (OCP + DIP Demo)## 📊 Example Output

```java

public class HybridEngine implements Engine {```

    @OverrideProducing Gas Car with Gas Engine

    public String getType() {Producing Electric Car with Electric Engine

        return "Hybrid Engine";```

    }

}## 🧪 Testing the Principles

```

### Adding New Car Types (OCP Demo)

## 📁 Project Structure```java

// Add this without modifying existing code:

```public class HybridCar extends Car {

SDTM-Labs/lab0/    public HybridCar(Engine engine) {

├── .gitignore        super("Hybrid Car", engine);

├── README.md    }

├── pom.xml                     # Maven configuration    

├── src/    @Override

│   └── main/    public void produce() {

│       └── java/        System.out.println("Producing " + name + " with " + engine.getType());

│           └── factory/        # Main package    }

└── target/                     # Build output (auto-generated)}

    └── classes/                # Compiled .class files```

```

### Adding New Engine Types (OCP + DIP Demo)

## 🛠️ Maven Configuration```java

public class HybridEngine implements Engine {

The project uses Maven for build management with:    @Override

- **Java 21** compilation target    public String getType() {

- **exec-maven-plugin** for easy execution        return "Hybrid Engine";

- Minimal dependencies for educational clarity    }

}

Key `pom.xml` features:```

```xml

<properties>## 📁 Project Structure

    <maven.compiler.source>21</maven.compiler.source>

    <maven.compiler.target>21</maven.compiler.target>```

</properties>SDTM-Labs/

```├── .gitignore

├── README.md

## Project Features

- Clean Architecture with separation of concerns
- Factory Pattern implementation
- Strategy Pattern for engine types
- Maven-based project structure
- Extensible design for new car and engine types

## Maven Configuration

The project uses Maven for build management:
```xml
<properties>
    <maven.compiler.source>21</maven.compiler.source>
    <maven.compiler.target>21</maven.compiler.target>
</properties>
```

## Repository Information

- Repository: [SDTM-Labs](https://github.com/Nickseen/SDTM-Labs)
- Branch: `lab0`
- Focus: SOLID Principles Implementation

```

## 🎓 Learning Outcomes

## 🛠️ Maven Configuration

After completing this lab, you will understand:

The project uses Maven for build management with:

1. **Single Responsibility Principle** - How to design classes with one reason to change- **Java 21** compilation target

2. **Open/Closed Principle** - How to extend functionality without modifying existing code- **exec-maven-plugin** for easy execution

3. **Dependency Inversion Principle** - How to depend on abstractions, not concretions- Minimal dependencies for educational clarity

4. **Factory Pattern** - How to encapsulate object creation logic

5. **Interface Segregation** - How to design focused, minimal interfacesKey `pom.xml` features:

6. **Maven Build System** - How to structure and build Java projects professionally```xml

<properties>

## 🔍 Code Walkthrough    <maven.compiler.source>21</maven.compiler.source>

    <maven.compiler.target>21</maven.compiler.target>

### Factory Pattern Implementation</properties>

```java```

public class CarFactory {

    public Car createCar(CarType type) {## 📈 Code Quality Features

        return switch (type) {

            case GAS -> new GasCar(new GasEngine());        // ← Concrete creation- ✅ **Clean Architecture** - Well-separated concerns

            case ELECTRIC -> new ElectricCar(new ElectricEngine());- ✅ **Readable Code** - Self-documenting class and method names

        };- ✅ **Extensible Design** - Easy to add new features

    }- ✅ **Standard Patterns** - Factory and Strategy patterns

}- ✅ **Professional Structure** - Maven-based project layout

```

## 🎓 Learning Outcomes

### Dependency Injection in Action

```javaAfter studying this project, you will understand:

public class ElectricCar extends Car {

    public ElectricCar(Engine engine) {  // ← Receives dependency1. **Single Responsibility Principle** - How to design classes with one reason to change

        super("Electric Car", engine);   // ← Injects to parent2. **Open/Closed Principle** - How to extend functionality without modifying existing code

    }3. **Dependency Inversion Principle** - How to depend on abstractions, not concretions

    4. **Factory Pattern** - How to encapsulate object creation logic

    @Override5. **Interface Segregation** - How to design focused, minimal interfaces

    public void produce() {6. **Maven Build System** - How to structure and build Java projects professionally

        // Uses injected dependency through interface

        System.out.println("Producing " + name + " with " + engine.getType());## 🔍 Code Walkthrough

    }

}### Factory Pattern Implementation

``````java

public class CarFactory {

## 🔗 Navigation    public Car createCar(CarType type) {

        return switch (type) {

- **Main Repository**: [SDTM-Labs](https://github.com/Nickseen/SDTM-Labs)            case GAS -> new GasCar(new GasEngine());        // ← Concrete creation

- **Other Labs**: Check other branches for additional laboratory exercises            case ELECTRIC -> new ElectricCar(new ElectricEngine());

- **Current Lab**: `lab0` - SOLID Principles        };

    }

## 📝 Lab Report}

```

### What was implemented:

- ✅ SRP: Single responsibility for each class### Dependency Injection in Action

- ✅ OCP: Extensible design via abstractions```java

- ✅ DIP: Dependency injection through interfacespublic class ElectricCar extends Car {

    public ElectricCar(Engine engine) {  // ← Receives dependency

### Key learning points:        super("Electric Car", engine);   // ← Injects to parent

- Understanding of SOLID principles in practice    }

- Factory pattern implementation    

- Clean code architecture    @Override

- Maven project structure    public void produce() {

        // Uses injected dependency through interface

---        System.out.println("Producing " + name + " with " + engine.getType());

    }

**Lab 0 - SOLID Principles Implementation** | *SDTM-Labs Repository*}
```

---