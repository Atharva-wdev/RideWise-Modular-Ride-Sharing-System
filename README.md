# 🚖 RideWise

RideWise is a console-based ride sharing application developed in Java that demonstrates object-oriented design principles and Low Level Design (LLD) concepts.

The project simulates a simplified ride-booking system similar to Uber or Ola and focuses on clean architecture rather than production-scale functionality.

---

## ✨ Features

- Rider Registration
- Driver Registration
- Ride Request
- Driver Assignment
- Ride Lifecycle Management
- Fare Calculation
- Receipt Generation
- Runtime Strategy Switching

---

## 🏗️ Tech Stack

- Java 17
- Maven
- IntelliJ IDEA
- Java Standard Library

---

## 📁 Project Structure

```
RideWise
│
├── pom.xml
│
├── src
│   ├── main
│   │   ├── java
│   │   │
│   │   └── com.airtribe.ridewise
│   │       ├── Main.java
│   │       ├── model
│   │       ├── strategy
│   │       ├── service
│   │       ├── exception
│   │       └── util
│   │
│   └── resources
│       └── docs
```

---

## 📌 Design Principles

The project demonstrates:

- SOLID Principles
- Composition over Inheritance
- Strategy Pattern
- Dependency Injection
- Low Coupling
- High Cohesion
- Encapsulation
- Polymorphism
- Law of Demeter

---

## 🎯 Strategy Pattern

### Ride Matching Strategy

- NearestDriverStrategy
- LeastActiveDriverStrategy

Strategies can be switched at runtime.

---

### Fare Strategy

- DefaultFareStrategy
- PeakHourFareStrategy

Fare calculation is completely decoupled from RideService.

---

## 🚕 Ride Lifecycle

```
REQUESTED
      │
      ▼
DRIVER_ASSIGNED
      │
      ▼
STARTED
      │
      ▼
COMPLETED

or

REQUESTED
      │
      ▼
CANCELLED
```

---

## ▶️ How to Run

Clone the repository

```bash
git clone https://github.com/<your-username>/ridewise.git
```

Move inside the project

```bash
cd ridewise
```

Compile

```bash
mvn clean compile
```

Run

```bash
mvn exec:java
```

Or simply execute `Main.java` from IntelliJ IDEA.

---

## 📚 Documentation

Detailed documentation is available in:

```
src/main/resources/docs
```

- Requirements.md
- Class_Model.md
- SOLID_Reflection.md
- Object_Relationships.md

---

## 🧪 Demonstration

The application demonstrates:

- Registering 3 riders
- Registering 5 drivers
- Booking rides
- Driver assignment using different strategies
- Ride completion
- Receipt generation
- Runtime strategy switching

---

## 👨‍💻 Author

Atharva Satunkar
