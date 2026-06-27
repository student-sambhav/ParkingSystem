package org.example.models.vehicle;

import org.example.enums.SpotSize;
import org.example.enums.VehicleType;
import org.example.models.ParkingSpot;

public class Motorcycle extends Vehicle{
    public Motorcycle(String licensePlate) {
        super(licensePlate, VehicleType.MOTORCYCLE, 1, SpotSize.SMALL);
    }
    public boolean canFitInSpot(ParkingSpot spot){
        return true;
    }
}
