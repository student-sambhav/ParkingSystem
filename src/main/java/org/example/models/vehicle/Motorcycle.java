package org.example.models.vehicle;

import org.example.enums.SpotSize;
import org.example.enums.VehicleType;
import org.example.models.ParkingSpot;

public class Motorcycle extends Vehicle{
    public Motorcycle(String liscensePlate, VehicleType type, int spotNeeded, SpotSize preferredSpotsize) {
        super(liscensePlate, type, spotNeeded, preferredSpotsize);
    }
    public boolean canFitInSpot(ParkingSpot spot){
        return true;
    }
}
