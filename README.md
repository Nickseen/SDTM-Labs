# 🏭 Car Factory - SOLID Principles Demo# Car Factory (SOLID Lab)



[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)## 🧠 Goal

[![Maven](https://img.shields.io/badge/Maven-3.1.0-blue.svg)](https://maven.apache.org/)This laboratory project demonstrates the use of **three SOLID principles** —  

[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)**SRP (Single Responsibility)**, **OCP (Open/Closed)**, and **DIP (Dependency Inversion)** —  

within a simple **Car Factory** application in Java.

A comprehensive Java project demonstrating **three core SOLID principles** through a practical Car Factory implementation. This educational repository showcases clean code architecture and object-oriented design patterns.

## 🏗️ Features

## 🎯 Project Overview- Create different types of cars (Gas / Electric)

- Use abstract factories to produce cars without modifying existing code

This laboratory project implements a car manufacturing system that demonstrates:- Inject engines via interfaces for flexible car creation

- **SRP (Single Responsibility Principle)**

- **OCP (Open/Closed Principle)** ## ⚙️ SOLID Principles Used

- **DIP (Dependency Inversion Principle)**- **SRP**: Each class handles one responsibility (e.g., `Car`, `Engine`, `CarFactory`).

- **OCP**: Adding new car types (e.g., HybridCar) doesn’t change existing code.

The system creates different types of cars (Gas and Electric) using a factory pattern with proper abstraction and dependency injection.- **DIP**: Cars depend on the abstract `Engine` interface, not concrete implementations.



## 🏗️ Architecture## ▶️ Run with Maven

```bash

```mvn compile exec:java -Dexec.mainClass="factory.Main"

src/main/java/factory/```

├── Main.java                    # Application entry point

├── car/## 🧩 Example Output

│   ├── Car.java                # Abstract base class```

│   ├── CarType.java            # Enumeration for car typesProducing Gas Car with Gas Engine

│   ├── ElectricCar.java        # Electric car implementationProducing Electric Car with Electric Engine

│   └── GasCar.java             # Gas car implementation```

├── engine/
│   ├── Engine.java             # Engine interface (abstraction)
│   ├── ElectricEngine.java     # Electric engine implementation
│   └── GasEngine.java          # Gas engine implementation
└── production/
    ├── CarFactory.java         # Factory for creating cars
    └── FactoryApp.java         # Application orchestrator
```

## 🔧 SOLID Principles Implementation

### 🎯 **SRP (Single Responsibility Principle)**
Each class has a single, well-defined responsibility:

```java
// Engine interface - Only defines engine behavior
public interface Engine {
    String getType();
}

// Car class - Only manages car properties and behavior
public abstract class Car {
    protected Engine engine;
    protected String name;
    public abstract void produce();
}
```

**Key Lines:**
- `public interface Engine` - Single responsibility for engine behavior
- `public abstract class Car` - Single responsibility for car structure
- `public class CarFactory` - Single responsibility for car creation

### 🔓 **OCP (Open/Closed Principle)**
The system is open for extension but closed for modification:

```java
// Adding new car types doesn't modify existing code
public class HybridCar extends Car {  // ← Extension without modification
    // New implementation
}
```

**Key Lines:**
- `abstract class Car` - Open for extension via inheritance
- `implements Engine` - Open for extension via interface implementation
- `extends Car` - Extension mechanism in action

### ⬇️ **DIP (Dependency Inversion Principle)**
High-level modules depend on abstractions, not concretions:

```java
public abstract class Car {
    protected Engine engine;  // ← Depends on abstraction (Engine interface)
    
    public Car(String name, Engine engine) {  // ← Dependency injection
        this.engine = engine;
    }
}
```

**Key Lines:**
- `Engine engine` - Dependency on abstraction
- Constructor injection - Inversion of control
- `engine.getType()` - Using interface, not concrete implementation

## 🚀 Getting Started

### Prerequisites
- Java 21 or higher
- Maven 3.6+ 
- Git

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/SDTM-Labs.git
   cd SDTM-Labs
   ```

2. **Compile the project**
   ```bash
   mvn compile
   ```

3. **Run the application**
   ```bash
   mvn exec:java
   ```
   
   Or with explicit main class:
   ```bash
   mvn compile exec:java -Dexec.mainClass="factory.Main"
   ```

### Alternative Execution

If you prefer manual compilation:
```bash
# Compile
javac -d target/classes src/main/java/factory/**/*.java

# Run
java -cp target/classes factory.Main
```

## 📊 Example Output

```
Producing Gas Car with Gas Engine
Producing Electric Car with Electric Engine
```

## 🧪 Testing the Principles

### Adding New Car Types (OCP Demo)
```java
// Add this without modifying existing code:
public class HybridCar extends Car {
    public HybridCar(Engine engine) {
        super("Hybrid Car", engine);
    }
    
    @Override
    public void produce() {
        System.out.println("Producing " + name + " with " + engine.getType());
    }
}
```

### Adding New Engine Types (OCP + DIP Demo)
```java
public class HybridEngine implements Engine {
    @Override
    public String getType() {
        return "Hybrid Engine";
    }
}
```

## 📁 Project Structure

```
SDTM-Labs/
├── .gitignore
├── README.md
├── pom.xml                     # Maven configuration
├── src/
│   └── main/
│       └── java/
│           └── factory/        # Main package
└── target/                     # Build output (auto-generated)
    └── classes/                # Compiled .class files
```

## 🛠️ Maven Configuration

The project uses Maven for build management with:
- **Java 21** compilation target
- **exec-maven-plugin** for easy execution
- Minimal dependencies for educational clarity

Key `pom.xml` features:
```xml
<properties>
    <maven.compiler.source>21</maven.compiler.source>
    <maven.compiler.target>21</maven.compiler.target>
</properties>
```

## 📈 Code Quality Features

- ✅ **Clean Architecture** - Well-separated concerns
- ✅ **Readable Code** - Self-documenting class and method names
- ✅ **Extensible Design** - Easy to add new features
- ✅ **Standard Patterns** - Factory and Strategy patterns
- ✅ **Professional Structure** - Maven-based project layout

## 🎓 Learning Outcomes

After studying this project, you will understand:

1. **Single Responsibility Principle** - How to design classes with one reason to change
2. **Open/Closed Principle** - How to extend functionality without modifying existing code
3. **Dependency Inversion Principle** - How to depend on abstractions, not concretions
4. **Factory Pattern** - How to encapsulate object creation logic
5. **Interface Segregation** - How to design focused, minimal interfaces
6. **Maven Build System** - How to structure and build Java projects professionally

## 🔍 Code Walkthrough

### Factory Pattern Implementation
```java
public class CarFactory {
    public Car createCar(CarType type) {
        return switch (type) {
            case GAS -> new GasCar(new GasEngine());        // ← Concrete creation
            case ELECTRIC -> new ElectricCar(new ElectricEngine());
        };
    }
}
```

### Dependency Injection in Action
```java
public class ElectricCar extends Car {
    public ElectricCar(Engine engine) {  // ← Receives dependency
        super("Electric Car", engine);   // ← Injects to parent
    }
    
    @Override
    public void produce() {
        // Uses injected dependency through interface
        System.out.println("Producing " + name + " with " + engine.getType());
    }
}
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- Inspired by Uncle Bob's Clean Code principles
- SOLID principles as defined by Robert C. Martin
- Java community best practices

## 📚 Further Reading

- [SOLID Principles](https://en.wikipedia.org/wiki/SOLID)
- [Clean Code by Robert C. Martin](https://www.amazon.com/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882)
- [Design Patterns](https://en.wikipedia.org/wiki/Design_Patterns)
- [Maven Getting Started Guide](https://maven.apache.org/guides/getting-started/)

---

**Made with ❤️ for learning SOLID principles**