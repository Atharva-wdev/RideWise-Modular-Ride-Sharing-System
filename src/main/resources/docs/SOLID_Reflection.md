# SOLID Reflection

## Single Responsibility

Every class has one responsibility.

- RiderService manages riders.
- DriverService manages drivers.
- RideService manages ride workflow.
- FareStrategy calculates fares.

---

## Open Closed

Ride matching and fare calculation are extendable without modifying RideService.

---

## Liskov Substitution

Any RideMatchingStrategy implementation can replace another.

The same applies to FareStrategy.

---

## Interface Segregation

Small focused interfaces.

RideMatchingStrategy

FareStrategy

---

## Dependency Inversion

RideService depends on abstractions.

RideMatchingStrategy

FareStrategy

instead of concrete implementations.