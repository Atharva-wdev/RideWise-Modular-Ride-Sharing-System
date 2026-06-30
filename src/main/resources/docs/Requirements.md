# RideWise

## Overview

RideWise is a console-based ride-sharing application that demonstrates object-oriented design and Low Level Design principles.

## Features

- Rider Registration
- Driver Registration
- Ride Request
- Driver Assignment
- Ride Lifecycle
- Fare Calculation
- Receipt Generation
- Runtime Strategy Switching

## Assumptions

- Locations are represented as strings.
- Distance is provided during ride request.
- One driver serves one ride at a time.
- Fare is calculated only after ride completion.

## Execution

```bash
mvn clean compile
mvn exec:java
```