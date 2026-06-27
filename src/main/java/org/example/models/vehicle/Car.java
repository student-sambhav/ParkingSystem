package org.example.models.vehicle;

import org.example.enums.SpotSize;
import org.example.enums.VehicleType;
import org.example.models.ParkingSpot;

public class Car extends Vehicle{
    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR, 1, SpotSize.MEDIUM);
    }

    public boolean canFitInSpot(ParkingSpot spot){
        return spot.getSize() == SpotSize.MEDIUM ||
                spot.getSize() == SpotSize.LARGE;
    }
}
