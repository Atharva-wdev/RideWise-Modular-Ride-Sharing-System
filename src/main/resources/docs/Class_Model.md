# Class Model

```
                  RideMatchingStrategy
                          ▲
            ┌─────────────┴──────────────┐
            │                            │
NearestDriverStrategy      LeastActiveDriverStrategy


                    FareStrategy
                         ▲
          ┌──────────────┴─────────────┐
          │                            │
DefaultFareStrategy      PeakHourFareStrategy


RideService
------------------------------
- requestRide()
- assignDriver()
- startRide()
- completeRide()
- cancelRide()

uses

RideMatchingStrategy
FareStrategy

Ride
------------------------
Ride
 ├── Rider
 ├── Driver
 └── FareReceipt
```