# Object Relationships

## Association

Ride references Rider and Driver.

## Composition

Ride owns FareReceipt.

If Ride is destroyed, FareReceipt has no meaning.

## Dependency7

RideService depends on

RideMatchingStrategy

FareStrategy

through constructor injection.