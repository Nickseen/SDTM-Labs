# Software Design Techniques and Mechanisms

Laboratory works focused on implementing and understanding design patterns in software development.

---

## Overview

This repository contains practical implementations of various design patterns organized by laboratory work assignments. Each branch represents a separate laboratory focusing on different pattern categories.

## Repository Structure

```
main                    - Repository overview (you are here)
├── lab1               - Creational Design Patterns
└── lab2               - Structural Design Patterns
```

---

## Laboratory Works

### Lab #1 - Creational Design Patterns
**Branch:** `lab1`

Implementation of creational design patterns in a Car Factory system:
- **Factory Method** - Engine creation abstraction
- **Builder Pattern** - Complex car object construction
- **Prototype Pattern** - Car cloning with body kit models

**Domain:** Automotive Manufacturing System

---

### Lab #2 - Structural Design Patterns
**Branch:** `lab2`

Extension of the Car Factory system with structural patterns:
- **Decorator Pattern** - Dynamic feature addition (GPS, Leather Seats, Sunroof, Premium Audio)
- **Proxy Pattern** - Test drive access control with validation
- **Facade Pattern** - Unified interface to complex subsystems

Integrates seamlessly with Lab #1 patterns, demonstrating how creational and structural patterns complement each other.

---

## Technologies

- **Language:** Java 21
- **Build Tool:** Maven 3.x
- **Architecture:** Layered (Client → Domain)
- **Total Patterns:** 6 (3 Creational + 3 Structural)

---

## Quick Start

```bash
# Clone the repository
git clone https://github.com/Nickseen/SDTM-Labs.git
cd SDTM-Labs

# Switch to specific lab branch
git checkout lab1    # For Lab #1 - Creational Patterns
# or
git checkout lab2    # For Lab #2 - Structural Patterns

# Build and run
mvn clean compile
java -cp target/classes client.Main
```

---

## Project Features

### Design Patterns Implementation
- Real-world applicable pattern implementations
- Clean, maintainable code following SOLID principles
- Comprehensive documentation with code examples
- Interactive CLI demonstrations

### Architecture
- Single client for entire system
- Proper package organization by responsibility
- Clear separation between creational and structural patterns
- Extensible design for future enhancements

### Documentation
- Detailed README for each laboratory work
- Code examples and usage patterns
- Screenshots demonstrating functionality
- Theory and practical motivation for each pattern

---

## Course Information

- **Course:** Software Design Techniques and Mechanisms
- **Institution:** Technical University of Moldova
- **Author:** Petcov Nicola

---

## License

This project is created for educational purposes as part of university coursework.

---

## Navigation

- View [Lab #1 - Creational Patterns](../../tree/lab1)
- View [Lab #2 - Structural Patterns](../../tree/lab2)
